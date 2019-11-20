(ns prototype-levers
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]))


(defn square-mounting-hole [[x-thickness y-thickness z-thickness :as thickness]
                            [x-translation y-translation z-translation :as translation]
                            inner-diameter]
  (let [outer-diameter (+ inner-diameter y-thickness)
        outer-radius (/ outer-diameter 2)]
    (->> (difference (union
                       (->> (cube x-thickness outer-diameter outer-diameter :center true)
                            (translate [0 (- (/ outer-diameter 2)) 0])))
                     (->> (cylinder (/ inner-diameter 2) (+ 0.4 x-thickness) :center true)
                          (rotate [0 (/ Math/PI 2) 0])
                          (with-fn 200)
                          (translate [-0.1 (- outer-radius) 0])))
         (translate [(/ x-thickness 2) 0 (+ z-thickness outer-radius)])
         (translate [x-translation y-translation (- (+ z-translation 1))])
         (translate [0 -1.4 1.1]))))


(defn back-row-lever [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                       [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                      [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                       [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                      hole-diameter]
  (union
    (->> (union (->> (cube 12.5 17 2 :center false)
                     (translate [0 0 0])))
         (translate [0 7.5 (- (/ 2 2))]))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter)
         (translate [0 0 -7]))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter)
         (translate [0 7 -7]))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter)
         (translate [0 14 -7]))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter)
         (translate [0 21 -7]))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter)
         (translate [0 28 -7]))
    (->> (square-mounting-hole thickness-front offset-front hole-diameter)
         (translate [0 28 0]))))


(defn middle-row-lever [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                         [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                        [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                         [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                        hole-diameter]
  (->> (union
         (->> (union (->> (cube 8.5 17 2 :center false)
                          (translate [0 0 0])))
              (translate [0 7.5 (- (/ 2 2))]))
         (->> (union (->> (square-mounting-hole thickness-front offset-front hole-diameter))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 0 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 7 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 14 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 21 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 28 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 35 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 42 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 49 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 49 0])))
              (translate [0 -3 0])))
       (translate [4 -18 0])))


(defn front-row-lever [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                        [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                       [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                        [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                       hole-diameter]
  (->> (union
         (->> (union (->> (cube 12.5 17 2 :center false)
                          (translate [0 -0.5 0]))
                     (->> (cylinder (/ 12.5 2) 2 :center false)
                          (with-fn 200)
                          (translate [(/ 12.5 2) 0 0])))
              (mirror [1 0 0])
              (translate [12.5 7.5 (- (/ 2 2))]))
         (->> (union (->> (square-mounting-hole thickness-front offset-front hole-diameter))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 0 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 7 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 14 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 21 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 28 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 35 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 42 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 49 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 56 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 63 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 70 -7]))
                     (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                          (translate [0 70 0])))
              (translate [10 -6 0])))
       (translate [0 -36 0])))

(defn side-rail [[[x-thickness-front y-thickness-front z-thickness-front :as thickness-front]
                  [x-offset-front y-offset-front z-offset-front :as offset-front] :as front]
                 [[x-thickness-rear y-thickness-rear z-thickness-rear :as thickness-rear]
                  [x-offset-rear y-offset-rear z-offset-rear :as offset-rear] :as rear]
                 hole-diameter]
  (->> (union
         (->> (union
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 0 -14]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 0 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 7 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 14 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 21 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 28 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 35 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 42 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 49 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 56 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 63 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 70 -7]))
                (->> (square-mounting-hole thickness-front offset-front hole-diameter)
                     (translate [0 70 -14]))
                )
              (translate [10 -6 0])))
       (translate [0 -36 0])))


(spit "../prototype-levers-3-rows.scad"
      (write-scad
        (union
          (let [third-row-args [[[2.5 4 1] [0 25.9 9]]
                                [[2.5 4 5] [0 40 9]]
                                4.775]]
            (union
              (apply back-row-lever third-row-args)
              (apply middle-row-lever third-row-args)
              (apply front-row-lever third-row-args)
              (->> (apply side-rail third-row-args)
                   (translate [10 0 0]))
              (->> (apply side-rail third-row-args)
                   (translate [-20 0 0])))))))


(let [third-row-args [[[2.5 4 1] [0 25.9 9]]
                      [[2.5 4 5] [0 40 9]]
                      4.775]]
  (spit "../prototype-levers-3-rows.scad"
        (write-scad
          (union
            (apply back-row-lever third-row-args)
            (apply middle-row-lever third-row-args)
            (apply front-row-lever third-row-args)
            (->> (apply side-rail third-row-args)
                 (translate [10 0 0]))
            (->> (apply side-rail third-row-args)
                 (translate [-20 0 0])))))

  (spit "../prototype-lever-back.scad"
        (write-scad
          (union
            (apply back-row-lever third-row-args))))
  (spit "../prototype-lever-middle.scad"
        (write-scad
          (union
            (apply middle-row-lever third-row-args))))
  (spit "../prototype-lever-front.scad"
        (write-scad
          (union
            (apply front-row-lever third-row-args))))
  (spit "../prototype-lever-side-rails.scad"
        (write-scad
          (union
            (apply side-rail third-row-args)))))