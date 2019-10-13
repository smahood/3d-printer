(ns keycap
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



(let [v-gap (/ 19 2)
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
      georgi-left (->> (union (->> left-star-col (translate [0 0 0]))
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
                                         (translate [0 10 0]))
                                    (->> (cube 4 40 4)
                                         (translate [0 25 -2]))
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
                                       (translate [0 40 -5])))
                      (translate [-18 0 0]))

      lever-front (->> (difference (union
                                     (->> (cube 13 4 4)
                                          (translate [0 -10 -9]))
                                     (->> (cube 4 4 14)
                                          (translate [0 -10 -3]))
                                     (->> (cube 4 55 4)
                                          (translate [4.5 16 -9]))
                                     (->> (cube 4 55 4)
                                          (translate [-4.5 16 -9]))
                                     (->> (cube 4 10 10)
                                          (translate [4.5 40 -5]))
                                     (->> (cube 4 10 10)
                                          (translate [-4.5 40 -5]))
                                     (->> (cube 4 35 4)
                                          (translate [4.5 54 -9]))
                                     (->> (cube 4 35 4)
                                          (translate [-4.5 54 -9]))
                                     (->> (cube 8 4 4)
                                          (translate [0 69.5 -9]))
                                     (->> (cube 4 4 8)
                                          (translate [0 69.5 -7])))
                                   (->> (cylinder 2 20)
                                        (with-fn 200)
                                        (rotate [0 (/ Math/PI 2) 0])
                                        (translate [0 40 -5])))
                       (translate [-18 0 0]))

      ]





  (spit "../choc-steno-cap.scad"
        (write-scad (->> (union georgi-left
                                #_georgi-right
                                #_case-left
                                (->> lever-mid
                                     (translate [3 0 0]))
                                lever-rear
                                lever-front)

                         ))))



