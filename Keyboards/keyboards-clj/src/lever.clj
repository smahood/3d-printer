(ns lever
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]))



(def depth 2)

(def depth-translate (+ depth 1.2))

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




(defn choc-steno-cap-rectangle [w]
  (let [top (union (->> (cube w 9 depth)
                        (translate [0 3 depth-translate]))
                   (->> (cube w 16 depth)
                        (translate [0 -8 depth-translate])))]

    (->> (union #_(translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                             choc-stem)
           #_(translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                        choc-stem)
           top)

         (rotate Math/PI [1 0 0]))))


(def choc-steno-cap-curved
  (let [top (union (->> (cube 12.5 9 depth)
                        (translate [0 -4.5 depth-translate]))
                   (->> (cube 12.5 8 depth)
                        (translate [0 4 depth-translate]))
                   (->> (->> (cylinder (/ 12.5 2) depth)
                             (with-fn 200)
                             (translate [0 8 depth-translate])))
                   )]

    (->> (union #_(translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                             choc-stem)
           #_(translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                        choc-stem)
           top)
         (rotate Math/PI [1 0 0]))))

(def choc-steno-cap-left-star-rectangle
  (let [top (union (->> (cube 17 10 depth)
                        (translate [-3 -11 depth-translate]))
                   (->> (cube 17 16 depth)
                        (translate [-3 1 depth-translate]))

                   )]

    (->> (union #_(translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                             choc-stem)
           #_(translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                        choc-stem)
           top)
         (rotate Math/PI [1 0 0]))))

(def choc-steno-cap-left-star
  (let [top (union (->> (cube 17 9 depth)
                        (translate [-3 -4.5 depth-translate]))
                   (->> (cube 17 8 depth)
                        (translate [-3 4 depth-translate]))
                   (->> (cube 17 4 depth)
                        (translate [-3 -10 depth-translate]))
                   (->> (->> (cylinder (/ 12.5 2) depth)
                             (with-fn 200)
                             (translate [-0.75 8 depth-translate])))
                   )]

    (->> (union #_(translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                             choc-stem)
           #_(translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                        choc-stem)
           top)
         (rotate Math/PI [1 0 0]))))

(def choc-steno-cap-right-star-rectangle
  (let [top (union (->> (cube 17 10 depth)
                        (translate [3 -11 depth-translate]))
                   (->> (cube 17 16 depth)
                        (translate [3 1 depth-translate]))

                   )]

    (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                top)
         (rotate Math/PI [1 0 0]))))



(def choc-steno-cap-right-star
  (let [top (union (->> (cube 17 9 depth)
                        (translate [3 -4.5 depth-translate]))
                   (->> (cube 17 8 depth)
                        (translate [3 4 depth-translate]))
                   (->> (cube 17 4 depth)
                        (translate [3 -10 depth-translate]))
                   (->> (->> (cylinder (/ 12.5 2) depth)
                             (with-fn 200)
                             (translate [0.75 8 depth-translate])))
                   )]

    (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                top)
         (rotate Math/PI [1 0 0]))))



(def choc-steno-cap-z
  (let [top (union (->> (cube 17 9 depth)
                        (translate [2 -4.5 depth-translate]))
                   (->> (cube 17 8 depth)
                        (translate [2 4 depth-translate]))
                   (->> (->> (cylinder (/ 12.5 2) depth)
                             (with-fn 200)
                             (translate [-0.25 8 depth-translate])))
                   )]

    (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                top)
         (rotate Math/PI [1 0 0]))))

(def choc-steno-cap-rectangle-z
  (let [top (union (->> (cube 17 9 depth)
                        (translate [2 3 depth-translate]))
                   (->> (cube 17 16 depth)
                        (translate [2 -8 depth-translate])))]

    (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                top)

         (rotate Math/PI [1 0 0]))))

(def choc-steno-cap-curve-s
  (let [top (union (->> (cube 12.5 9 depth)
                        (translate [0 -4.5 depth-translate]))
                   (->> (cube 12.5 8 depth)
                        (translate [0 4 depth-translate]))
                   (->> (cube 12.5 8 depth)
                        (translate [0 -8 depth-translate]))
                   (->> (->> (cylinder (/ 12.5 2) depth)
                             (with-fn 200)
                             (translate [0 8 depth-translate]))))]

    (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                top)
         (rotate Math/PI [1 0 0]))))



#_(let [v-gap (/ 19 2)
        h-gap 18
        s-col (union (->> (choc-steno-cap-rectangle 12.5)
                          (translate [0 v-gap 0]))
                     (->> choc-steno-cap-curve-s
                          (translate [0 (- v-gap) 0])))
        col (union (->> (choc-steno-cap-rectangle 12.5)
                        (translate [0 v-gap 0]))
                   (->> choc-steno-cap-curved
                        (translate [0 (- v-gap) 0])))
        left-star-col (union (->> choc-steno-cap-left-star-rectangle
                                  (translate [0 v-gap 0]))
                             (->> choc-steno-cap-left-star
                                  (translate [0 (- v-gap) 0])))
        right-star-col (union (->> choc-steno-cap-right-star-rectangle
                                   (translate [0 v-gap 0]))
                              (->> choc-steno-cap-right-star
                                   (translate [0 (- v-gap) 0])))
        z-col (union (->> choc-steno-cap-rectangle-z
                          (translate [0 v-gap 0]))
                     (->> choc-steno-cap-z
                          (translate [0 (- v-gap) 0])))
        georgi-left (->> (union #_(->> left-star-col (translate [0 0 0]))
                           (->> col (translate [h-gap 0 0]))
                           #_(->> col (translate [(* 2 h-gap) 0 0]))
                           #_(->> col (translate [(* 3 h-gap) 0 0]))
                           #_(->> s-col (translate [(* 4 h-gap) 0 0]))
                           #_(->> col (translate [(* 5 h-gap) 0 0]))

                           )
                         (rotate Math/PI [0 1 0]))

        georgi-right (->> (union (->> right-star-col)
                                 (->> col (translate [(- h-gap) 0 0]))
                                 (->> col (translate [(- (* 2 h-gap)) 0 0]))
                                 (->> col (translate [(- (* 3 h-gap)) 0 0]))
                                 (->> col (translate [(- (* 4 h-gap)) 0 0]))
                                 (->> z-col (translate [(- (* 5 h-gap)) 0 0]))
                                 )
                          (rotate Math/PI [0 1 0])
                          (translate [(* 5 h-gap) 0 0]))

        case-left (union
                    (->> (cube 5 100 50)
                         (translate [20 10 0]))
                    (->> (cube 5 100 50)
                         (translate [-105 10 0])))

        lever-mid (difference (union
                                (->> (cube 4 10 8))
                                (->> (cube 4 50 4)
                                     (translate [0 20 -2]))
                                (->> (cube 4 10 10)
                                     (translate [0 40 -6]))
                                (->> (cube 4 30 4)
                                     (translate [0 50 -9]))
                                (->> (cube 4 4 8)
                                     (translate [0 63 -7]))
                                )
                              (->> (cylinder 2 5)
                                   (with-fn 200)
                                   (rotate [0 (/ Math/PI 2) 0])
                                   (translate [0 40 -5]))

                              )

        lever-rear (->> (difference (union
                                      (->> (cube 4 10 8)
                                           (translate [-4.25 10 0]))
                                      (->> (cube 4 40 4)
                                           (translate [-4.25 25 -2]))
                                      (->> (cube 4 10 10)
                                           (translate [-4.25 40 -6]))
                                      (->> (cube 4 30 4)
                                           (translate [-4.25 50 -9]))
                                      (->> (cube 4 4 8)
                                           (translate [-4.25 63 -7]))
                                      )
                                    (->> (cylinder 2 5)
                                         (with-fn 200)
                                         (rotate [0 (/ Math/PI 2) 0])
                                         (translate [-4.25 40 -5])))
                        (translate [-18 0 0]))

        lever-front (->> (difference (union
                                       #_(->> (cube 13 4 4)
                                              (translate [0 -10 -9]))
                                       (->> (cube 4 4 14)
                                            (translate [4.25 -10 -4]))
                                       (->> (cube 4 55 4)
                                            (translate [4.25 16 -9]))
                                       #_(->> (cube 4 55 4)
                                              (translate [-4.5 16 -9]))
                                       (->> (cube 4 10 10)
                                            (translate [4.25 38.5 -5]))
                                       #_(->> (cube 4 10 10)
                                              (translate [-4.5 40 -5]))
                                       (->> (cube 4 30 4)
                                            (translate [4.25 50 -9]))
                                       #_(->> (cube 4 35 4)
                                              (translate [-4.5 54 -9]))
                                       #_(->> (cube 8 4 4)
                                              (translate [0 69.5 -9]))
                                       (->> (cube 4 4 8)
                                            (translate [4.5 63 -7])))
                                     (->> (cylinder 2 20)
                                          (with-fn 200)
                                          (rotate [0 (/ Math/PI 2) 0])
                                          (translate [0 40 -5])))
                         (translate [-18 0 0]))

        ]





    (spit "../lever.scad"
          (write-scad (->> (union georgi-left
                                  #_georgi-right
                                  #_case-left
                                  #_(->> lever-mid
                                         (translate [3 0 0]))
                                  lever-rear
                                  lever-front)

                           ))))

(defn spacer []
  (difference (->> (cube 4 10 10)
                   (translate [-0.25 38.5 -5]))
              (->> (cylinder 2 20)
                   (with-fn 200)
                   (rotate [0 (/ Math/PI 2) 0])
                   (translate [0 38.5 -5])))

  )





(defn keycap-front [thickness]
  (->> (union (->> (cube 12.5 17 thickness :center false)
                   (translate [0 -0.5 0]))
              (->> (cylinder (/ 12.5 2) thickness :center false)
                   (with-fn 200)
                   (translate [(/ 12.5 2) 0 0])))
       (mirror [1 0 0])
       (translate [0 (- 10) (- (/ thickness 2))])))


(defn keycap-rear [thickness]
  (->> (union (->> (cube 12.5 17 thickness :center false)
                   (translate [0 -0.5 0])))
       (translate [0 (- 10) (- (/ thickness 2))])))

(defn keycap-third-row [thickness]
  (->> (union (->> (cube 12.5 17 thickness :center false)
                   (translate [0 -0.5 0])))
       (translate [0 9 (- (/ thickness 2))])))



(defn keycap-vertical-arm
  "Vertical arm of the lever keys (keycap side)"
  [[x-thickness y-thickness z-thickness :as thickness]
   [x-translation y-translation z-translation :as translation]]
  (->> (cube x-thickness y-thickness z-thickness :center false)
       (mirror [0 0 1])
       (mirror [0 1 0])
       (translate [x-translation (- y-translation) z-translation])))

(defn keycap-horizontal-arm
  "Horizontal arm of the lever keys (keycap side)"
  [[x-thickness y-thickness z-thickness :as thickness]
   [x-translation y-translation z-translation :as translation]]
  (->> (cube x-thickness y-thickness z-thickness :center false)
       (mirror [0 0 1])
       (translate [x-translation (- y-translation) (- (- z-translation z-thickness))])))

(defn contact-horizontal-arm
  "Horizontal arm of the lever contact (opposite side of keycaps)"
  [[x-thickness y-thickness z-thickness :as thickness]
   [x-translation y-translation z-translation :as translation]]
  (->> (cube x-thickness y-thickness z-thickness :center false)
       (mirror [0 1 0])
       (mirror [0 0 1])
       (translate [x-translation y-translation z-translation]))
  )


(defn contact-vertical-arm
  "Vertical arm of the lever contact (opposite side of keycaps)"
  [[x-thickness y-thickness z-thickness :as thickness]
   [x-translation y-translation z-translation :as translation]]
  (->> (cube x-thickness y-thickness z-thickness :center false)
       (mirror [0 0 1])
       (mirror [0 1 0])
       #_(translate [0 0 (- z-translation)])
       (translate [x-translation y-translation z-translation]))

  )

(defn mounting-hole [[x-thickness y-thickness z-thickness :as thickness]
                     [x-translation y-translation z-translation :as translation]
                     inner-diameter]
  (let [outer-diameter (+ inner-diameter y-thickness)
        circle-thickness (/ (- outer-diameter inner-diameter) 2)
        outer-radius (/ outer-diameter 2)]
    (->> (difference (union (->> (cube x-thickness outer-diameter z-thickness :center false)
                                 (translate [0 (- outer-diameter) (- (/ outer-diameter 2))]))
                            (->> (cube x-thickness circle-thickness z-thickness :center false)
                                 (translate [0 (- circle-thickness) (- z-thickness)]))
                            (->> (cube x-thickness circle-thickness z-thickness :center false)
                                 (translate [0 (- outer-diameter) (- z-thickness)]))
                            (->> (cylinder outer-radius x-thickness :center false)
                                 (with-fn 200)
                                 (rotate [0 (/ Math/PI 2) 0])
                                 (translate [0 (- outer-radius) 0])))
                     (->> (cylinder (/ inner-diameter 2) (+ 0.2 x-thickness) :center false)
                          (rotate [0 (/ Math/PI 2) 0])
                          (with-fn 200)
                          (translate [-0.1 (- outer-radius) 0])))
         (translate [0 0 (+ z-thickness outer-radius)])
         (translate [x-translation y-translation (- (+ z-translation 1))])))

  )

(defn lever-front [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                    [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                   [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                    [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                   hole-diameter front-offset]
  (let [y-offset-front (+ y-offset-front front-offset)
        y-offset-rear (+ y-offset-rear front-offset)]
    (union
      (keycap-front 2)
      (mirror [1 0 0] (union (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                                                  [x-offset-front 0 0])
                             (keycap-horizontal-arm [x-thickness-front (+ y-offset-front y-thickness-front) z-thickness-front]
                                                    [x-offset-front y-thickness-front z-offset-front])
                             (mounting-hole thickness-front
                                            [x-offset-front y-offset-front z-offset-front]
                                            hole-diameter)
                             (contact-horizontal-arm [x-thickness-rear (- y-offset-rear y-offset-front) z-thickness-rear]
                                                     [x-offset-rear y-offset-rear (- z-thickness-rear z-offset-front)])

                             (contact-vertical-arm [x-thickness-rear y-thickness-rear z-offset-rear]
                                                   [x-offset-rear y-offset-rear (- z-offset-rear z-offset-front)]))))))

(defn lever-rear [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                   [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                  [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                   [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                  hole-diameter]
  (union
    (keycap-rear 2)
    (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                         [x-offset-front 0 0])
    (keycap-horizontal-arm [x-thickness-front y-offset-front z-thickness-front]
                           [x-offset-front 0 z-offset-front])
    (mounting-hole thickness-front
                   [x-offset-front y-offset-front z-offset-front]
                   hole-diameter)
    (contact-vertical-arm [x-thickness-rear y-thickness-rear z-offset-rear]
                          [x-offset-rear y-offset-rear (- z-offset-rear z-offset-front)])
    (contact-horizontal-arm [x-thickness-rear (- y-offset-rear y-offset-front) z-thickness-rear]
                            [x-offset-rear y-offset-rear (- z-thickness-rear z-offset-front)])))


(defn lever-thumb [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                    [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                   [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                    [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                   hole-diameter reverse-arm?]
  (let [y-offset-front y-offset-front
        y-offset-rear y-offset-rear
        reverse-arm (if reverse-arm? [(+ -12.5 x-thickness-front) 0 0] [0 0 0])]
    (union
      (keycap-front 2)
      (translate reverse-arm (mirror [1 0 0] (union (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                                                                         [x-offset-front 0 0])
                                                    (keycap-horizontal-arm [x-thickness-front (+ y-offset-front y-thickness-front) z-thickness-front]
                                                                           [x-offset-front y-thickness-front z-offset-front])
                                                    (mounting-hole thickness-front
                                                                   [x-offset-front y-offset-front z-offset-front]
                                                                   hole-diameter)
                                                    (contact-horizontal-arm [x-thickness-rear (- y-offset-rear y-offset-front) z-thickness-rear]
                                                                            [x-offset-rear y-offset-rear (- z-thickness-rear z-offset-front)])

                                                    (contact-vertical-arm [x-thickness-rear y-thickness-rear z-offset-rear]
                                                                          [x-offset-rear y-offset-rear (- z-offset-rear z-offset-front)])))))))


(defn lever-number [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                     [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                    [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                     [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                    hole-diameter keycap-thickness]
  (let [y-offset-keycap -13.5]
    (union (translate [4.25 0 0]
                      (union (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                                                  [x-offset-front y-offset-keycap 0])
                             (keycap-horizontal-arm [x-thickness-front (+ y-offset-front y-thickness-front y-offset-keycap) z-thickness-front]
                                                    [x-offset-front (+ y-thickness-front y-offset-keycap) z-offset-front])
                             (mounting-hole thickness-front
                                            [x-offset-front y-offset-front z-offset-front]
                                            hole-diameter)))
           (translate [28.75 0 0]
                      (union (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                                                  [x-offset-front y-offset-keycap 0])
                             (keycap-horizontal-arm [x-thickness-front (+ y-offset-front y-thickness-front y-offset-keycap) z-thickness-front]
                                                    [x-offset-front (+ y-thickness-front y-offset-keycap) z-offset-front])
                             (mounting-hole thickness-front
                                            [x-offset-front y-offset-front z-offset-front]
                                            hole-diameter)
                             (contact-horizontal-arm [x-thickness-rear (- y-offset-rear y-offset-front) z-thickness-rear]
                                                     [x-offset-rear y-offset-rear (- z-thickness-rear z-offset-front)])
                             (contact-vertical-arm [x-thickness-rear y-thickness-rear z-offset-rear]
                                                   [x-offset-rear y-offset-rear (- z-offset-rear z-offset-front)])))
           (translate [69 0 0]
                      (union (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                                                  [x-offset-front y-offset-keycap 0])
                             (keycap-horizontal-arm [x-thickness-front (+ y-offset-front y-thickness-front y-offset-keycap) z-thickness-front]
                                                    [x-offset-front (+ y-thickness-front y-offset-keycap) z-offset-front])
                             (mounting-hole thickness-front
                                            [x-offset-front y-offset-front z-offset-front]
                                            hole-diameter)))
           (->> (union (->> (cube 78.25 17 keycap-thickness :center false)
                            (translate [0 -0.5 0])))
                (translate [0 10 (- (/ keycap-thickness 2))])))))


(defn lever-front-and-rear [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                             [x-offset-front y-offset-front z-offset-front :as offset-front]]
                            [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                             [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                            hole-diameter
                            ]
  (let [front-offset 19]
    (union
      (lever-rear [thickness-front offset-front]
                  [thickness-rear offset-rear]
                  hole-diameter)
      (translate [12.5 (- front-offset) 0]
                 (lever-front [thickness-front offset-front]
                              [thickness-rear offset-rear]
                              hole-diameter front-offset)))))

(defn lever-single-third-row [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                               [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                              [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                               [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                              hole-diameter]
  (let [keycap-offset 3.5
        row-offset -19]
    (union
      (keycap-third-row 2)
      (keycap-vertical-arm [x-thickness-front y-thickness-front z-offset-front]
                           [keycap-offset row-offset 0])
      (keycap-horizontal-arm [x-thickness-front (+ y-offset-front row-offset) z-thickness-front]
                             [keycap-offset row-offset z-offset-front])
      (mounting-hole thickness-front
                     [keycap-offset y-offset-front z-offset-front]
                     hole-diameter)
      (contact-vertical-arm [x-thickness-rear y-thickness-rear z-offset-rear]
                            [keycap-offset y-offset-rear (- z-offset-rear z-offset-front)])
      (contact-horizontal-arm [x-thickness-rear (- y-offset-rear y-offset-front) z-thickness-rear]
                              [keycap-offset y-offset-rear (- z-thickness-rear z-offset-front)]))))


(defn lever-3-rows [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                     [x-offset-front y-offset-front z-offset-front :as offset-front]]
                    [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                     [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                    hole-diameter]
  (let [front-offset 19] (union
                           (lever-single-third-row [thickness-front offset-front]
                                                   [thickness-rear offset-rear]
                                                   hole-diameter)
                           (lever-rear [thickness-front offset-front]
                                       [thickness-rear offset-rear]
                                       hole-diameter)

                           (translate [12.5 (- front-offset) 0]
                                      (lever-front [thickness-front offset-front]
                                                   [thickness-rear offset-rear]
                                                   hole-diameter front-offset)))))




(let [thickness-front [2.5 4 5]
      offset-front [0 30 20]
      thickness-rear [2.5 4 9]
      offset-rear [0 35 20]
      hole-diameter 4.775
      double-levers (lever-front-and-rear [thickness-front offset-front]
                                          [thickness-rear offset-rear]
                                          hole-diameter)
      third-row-levers (lever-3-rows [thickness-front offset-front]
                                     [thickness-rear offset-rear]
                                     hole-diameter)

      row-offsets (->> (range 5)
                       (mapv #(* 16 %))
                       (mapv #(vector % 0 0)))
      thumb-offset-x 63.75
      front-offset 19]
  (spit "../lever-left-hand-number-bar.scad"
        (write-scad
          (apply union (conj (mapv #(translate % double-levers) row-offsets)
                             (translate [thumb-offset-x -45 -9] (lever-thumb [thickness-front [0 75 11]]
                                                                             [thickness-rear [0 90 20]]
                                                                             hole-diameter false))
                             (translate [(- thumb-offset-x 13) -45 -9] (lever-thumb [thickness-front [0 75 11]]
                                                                                    [thickness-rear [0 90 20]]
                                                                                    hole-diameter true))
                             (lever-number [thickness-front offset-front]
                                           [thickness-rear offset-rear]
                                           hole-diameter 2)))))

  (spit "../lever-left-hand-3-rows.scad"
        (write-scad
          (apply union (conj (mapv #(translate % third-row-levers) row-offsets)

                             (translate [thumb-offset-x (- (second offset-rear) 80) -9]
                                        (lever-thumb [thickness-front [0 75 11]]
                                                     [thickness-rear [0 80 20]]
                                                     hole-diameter false))
                             (translate [(- thumb-offset-x 13) (- (second offset-rear) 80) -9]
                                        (lever-thumb [thickness-front [0 75 11]]
                                                     [thickness-rear [0 80 20]]
                                                     hole-diameter true))
                             ))))

  (spit "../lever-front.scad"
        (write-scad
          (lever-front [thickness-front offset-front]
                       [thickness-rear offset-rear]
                       hole-diameter front-offset)))

  (spit "../lever-rear.scad"
        (write-scad
          (lever-rear [thickness-front offset-front]
                      [thickness-rear offset-rear]
                      hole-diameter)))

  (spit "../lever-thumb.scad"
        (write-scad
          (lever-thumb [thickness-front [0 75 11]]
                       [thickness-rear [0 90 20]]
                       hole-diameter true)))

  (spit "../lever-front-back.scad"
        (write-scad (lever-front-and-rear [thickness-front offset-front]
                                          [thickness-rear offset-rear]
                                          hole-diameter)))

  )









