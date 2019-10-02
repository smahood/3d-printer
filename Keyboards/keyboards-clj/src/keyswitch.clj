(ns keyswitch
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]))



(def flexible-spring
  (union
    (difference
      (cube 10 10 10)
      (cube 9 9 11)
      )))


(comment (spit "../flexible-spring.scad"
               (write-scad flexible-spring)))


(let [outer-circle (difference (->> (circle 5)
                                    (with-fn 200)
                                    (extrude-linear {:height 5})))

      ellipses (union
                 (->> outer-circle (resize [20 10]))
                 (->> outer-circle (resize [10 20])))
      flexible-spring-2 (difference ellipses
                                    (union
                                      (->> outer-circle (resize [18 8 6]))
                                      (->> outer-circle (resize [8 18 6]))))
      ]

  (spit "../flexible-spring.scad"
        (write-scad flexible-spring-2))
  )





