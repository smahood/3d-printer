(ns keycap
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


(def choc-steno-cap
  (let [h 1
        top (->> (cube 18 18 h)
                 (translate [0 0 2.2]))

        ]

    (->> (union (translate [(/ 5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                (translate [(/ -5.7 2) 0 (+ 2 (/ -3.4 2))]
                           choc-stem)
                top
                )

         (rotate Math/PI [1 0 0]))))

(spit "../choc-steno-cap.scad"
      (write-scad choc-steno-cap))



