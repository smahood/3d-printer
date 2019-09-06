(ns georgi
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]))


(def choc-stem
  (union
    (difference
      (->> (cube 1.2 3 3.4))
      (->> (cylinder (/ 7 2) 3.5)
           (with-fn 200)
           (translate [3.9 0 0]))
      (->> (cylinder (/ 7 2) 3.5)
           (with-fn 200)
           (translate [-3.9 0 0])))))


(def choc-cap
  (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                         choc-stem)
              (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                         choc-stem)
              (->> (cube 18 18 0.5)
                   (translate [0 0 2.2])))
       (rotate Math/PI [1 0 0])))





(def georgi-layout
  (let [horizontal 18
        vertical 3
        cols 6]
    (->> (for [col (range cols)]
           (->> choc-cap
                (translate [(* col horizontal) 0 0])))
         union)))

(def layout-box
  (union
    (->> (cube 2 18 5)
         (translate [9 0 0]))
    (->> (cube 2 18 5)
         (translate [-9 0 0]))
    (->> (cube 18 2 5)
         (translate [0 8 0]))
    (->> (cube 18 2 5)
         (translate [0 -8 0])))
  )

(def layout-column
  (union
    layout-box
    #_(->> layout-box
           (translate [18 0 0]))
    (->> layout-box
         (translate [0 18 0]))))




(def gluing-jig
  (let [nozzle-width 0.4
        layer-height 0.28
        extra-space 1
        hole-x 1.5
        hole-y 3.3
        hole-height 6
        hole-separation 5.7
        y-dist (+ 19 extra-space)
        x-dist (+ 18 extra-space)
        mount-height (+ hole-y (* 12 nozzle-width))
        mount-width (+ hole-separation hole-y (* 8 nozzle-width))
        base-thickness (* 2 layer-height)
        mount (cube mount-width mount-height base-thickness)
        x-connector-height (* nozzle-width 4)
        x-connector (cube mount-width x-connector-height base-thickness)
        x-connector-top (translate [-8 (- (/ mount-height 2) (/ x-connector-height 2)) 0] x-connector)
        x-connector-bottom (translate [-8 (- (/ x-connector-height 2) (/ mount-height 2)) 0] x-connector)
        y-connector-width (* nozzle-width 4)
        y-connector (cube y-connector-width y-dist base-thickness)
        y-connector-middle (translate [0 (- mount-height) 0] y-connector)
        y-connector-left (translate [(+ (/ (- mount-width) 2) (/ y-connector-width 2)) (- mount-height) 0]
                                    y-connector)
        y-connector-right (translate [(+ (/ mount-width 2) (/ (- y-connector-width) 2)) (- mount-height) 0]
                                     y-connector)
        hole-size (cube hole-x hole-y hole-height)
        stem-depth (* 11 layer-height) #_3.4
        stem-glue-mount (->> (difference (cube (+ (* 4 nozzle-width) hole-x)
                                               (+ (* 4 nozzle-width) hole-y) stem-depth)
                                         hole-size)
                             (translate [0 0 (/ stem-depth 2)]))
        stem-holes (union (translate [(/ hole-separation 2) 0 0]
                                     hole-size)
                          (translate [(/ (- hole-separation) 2) 0 0]
                                     hole-size))
        make-cap-hole (fn [border-shape position]
                        (translate position
                                   (difference (union
                                                 (difference border-shape
                                                             stem-holes)
                                                 (translate [(/ hole-separation 2) 0 0]
                                                            stem-glue-mount)
                                                 (translate [(/ (- hole-separation) 2) 0 0]
                                                            stem-glue-mount)))))
        positions [[mount [0 0 0]]

                   [(union mount y-connector-left)
                    [0 x-dist 0]]

                   [(union mount x-connector-bottom)
                    [y-dist 0 0]]

                   [(union mount x-connector-top y-connector-middle
                           (mirror [1 0 0] x-connector-top))
                    [y-dist x-dist 0]]

                   [(union mount
                           (->> x-connector-bottom)

                           #_(->> (cube 7.6 2 0.6)
                                  (rotate 0.28 [0 0 1])
                                  (translate [-9 -4 0])))
                    [(- (* 2 y-dist) 1) 2 0]]

                   [(union mount y-connector-middle
                           (mirror [1 0 0] x-connector-top)
                           #_(->> (cube 7.6 2 0.6)
                                  (rotate 0.28 [0 0 1])
                                  (translate [-9 2 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 2 y-dist) 1) (+ x-dist 2.1) 0]]

                   [(union mount x-connector-bottom
                           (mirror [1 0 0] x-connector-bottom)
                           #_(->> (cube 9 2 0.6)
                                  (rotate 0.4 [0 0 1])
                                  (translate [-9.3 -4 0])))
                    [(- (* 3 y-dist) 1.5) 5 0]]
                   [(union mount y-connector-middle

                           #_(->> (cube 9 2 0.6)
                                  (rotate 0.4 [0 0 1])
                                  (translate [-9.5 1 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 3 y-dist) 1.5) (+ x-dist 5.1) 0]]
                   [(union mount (mirror [1 0 0] x-connector-bottom)
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.3 -1 0])))
                    [(- (* 4 y-dist) 2) 2 0]]
                   [(union mount y-connector-middle x-connector-top
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.5 4 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 4 y-dist) 2) (+ x-dist 2.1) 0]]
                   [(union mount
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.3 -1.2 0])))
                    [(- (* 5 y-dist) 3) -1 0]]

                   [(union mount x-connector-top
                           y-connector-right
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.3 4 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 5 y-dist) 3) (+ x-dist -1 +0.1) 0]]
                   ]
        ]


    (union
      (->> positions
           (map #(apply make-cap-hole %))
           (apply union))))

  )


(def cutting-jig
  (let [nozzle-width 0.4
        layer-height 0.28
        extra-space 1
        hole-x 1.5
        hole-y 3.3
        hole-height 6
        hole-separation 5.7
        y-dist (+ 19 extra-space)
        x-dist (+ 18 extra-space)
        mount-height (+ hole-y (* 12 nozzle-width))
        mount-width (+ hole-separation hole-y (* 8 nozzle-width))
        base-thickness (* 2 layer-height)
        mount (cube mount-width mount-height base-thickness)
        x-connector-height (* nozzle-width 4)
        x-connector (cube mount-width x-connector-height base-thickness)
        x-connector-top (translate [-8 (- (/ mount-height 2) (/ x-connector-height 2)) 0] x-connector)
        x-connector-bottom (translate [-8 (- (/ x-connector-height 2) (/ mount-height 2)) 0] x-connector)
        y-connector-width (* nozzle-width 4)
        y-connector (cube y-connector-width y-dist base-thickness)
        y-connector-middle (translate [0 (- mount-height) 0] y-connector)
        y-connector-left (translate [(+ (/ (- mount-width) 2) (/ y-connector-width 2)) (- mount-height) 0]
                                    y-connector)
        y-connector-right (translate [(+ (/ mount-width 2) (/ (- y-connector-width) 2)) (- mount-height) 0]
                                     y-connector)
        hole-size (cube hole-x hole-y hole-height)
        stem-depth (* 11 layer-height) #_3.4
        stem-glue-mount (->> (difference (cube (+ (* 4 nozzle-width) hole-x)
                                               (+ (* 4 nozzle-width) hole-y) stem-depth)
                                         hole-size)
                             (translate [0 0 (/ stem-depth 2)]))
        stem-holes (union (translate [(/ hole-separation 2) 0 0]
                                     hole-size)
                          (translate [(/ (- hole-separation) 2) 0 0]
                                     hole-size))
        make-cap-hole (fn [border-shape position]
                        (translate position
                                   (difference (union
                                                 (difference border-shape
                                                             stem-holes)
                                                 (translate [(/ hole-separation 2) 0 0]
                                                            stem-glue-mount)
                                                 (translate [(/ (- hole-separation) 2) 0 0]
                                                            stem-glue-mount)))))
        positions [[mount [0 0 0]]

                   [(union mount y-connector-left)
                    [0 x-dist 0]]

                   [(union mount x-connector-bottom)
                    [y-dist 0 0]]

                   [(union mount x-connector-top y-connector-middle
                           (mirror [1 0 0] x-connector-top))
                    [y-dist x-dist 0]]

                   [(union mount
                           (->> x-connector-bottom)

                           #_(->> (cube 7.6 2 0.6)
                                  (rotate 0.28 [0 0 1])
                                  (translate [-9 -4 0])))
                    [(- (* 2 y-dist) 1) 2 0]]

                   [(union mount y-connector-middle
                           (mirror [1 0 0] x-connector-top)
                           #_(->> (cube 7.6 2 0.6)
                                  (rotate 0.28 [0 0 1])
                                  (translate [-9 2 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 2 y-dist) 1) (+ x-dist 2.1) 0]]

                   [(union mount x-connector-bottom
                           (mirror [1 0 0] x-connector-bottom)
                           #_(->> (cube 9 2 0.6)
                                  (rotate 0.4 [0 0 1])
                                  (translate [-9.3 -4 0])))
                    [(- (* 3 y-dist) 1.5) 5 0]]
                   [(union mount y-connector-middle

                           #_(->> (cube 9 2 0.6)
                                  (rotate 0.4 [0 0 1])
                                  (translate [-9.5 1 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 3 y-dist) 1.5) (+ x-dist 5.1) 0]]
                   [(union mount (mirror [1 0 0] x-connector-bottom)
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.3 -1 0])))
                    [(- (* 4 y-dist) 2) 2 0]]
                   [(union mount y-connector-middle x-connector-top
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.5 4 0]))
                           #_(->> (cube 2 13 0.6)
                                  (translate [0 -8 0])))
                    [(- (* 4 y-dist) 2) (+ x-dist 2.1) 0]]
                   [(union mount
                           #_(->> (cube 9 2 0.6)
                                  (rotate -0.4 [0 0 1])
                                  (translate [-9.3 -1.2 0])))
                    [(- (* 5 y-dist) 3) -1 0]]

                   [(union mount x-connector-top y-connector-right)
                    [(- (* 5 y-dist) 3) (+ x-dist -1 +0.1) 0]]
                   ]
        ]


    (union
      (->> positions
           (map #(apply make-cap-hole %))
           (apply union))))

  )


(comment (spit "../georgi-key-gluing-jig.scad"
               (write-scad gluing-jig)))

(comment (spit "../georgi-key-cutting-jig.scad"
               (write-scad cutting-jig)))



(comment (spit "things/shaun-choc-18.scad"
               (write-scad choc-cap)))

(comment (spit "things/shaun-georgi.scad"
               (write-scad georgi-layout)))

