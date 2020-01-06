(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn find_digits
  [num digits]
  (if (< num 10)
    (conj digits num)
    (recur (quot num 10) (conj digits (rem num 10)))))

(defn armstrong?
  [num]
  (let [nums (find_digits num []) power (count nums)]
    (= (reduce (fn
                 [result digit]
                 (+ result (expt digit power))) 0 nums) num)))
