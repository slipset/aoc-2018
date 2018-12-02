(ns aoc.aoc-2018-12-02
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(def input (str/split-lines (slurp "resources/input-2018-12-02.txt")))

(->> input
     (map (comp set vals frequencies))
     (keep (comp seq (partial set/intersection #{2 3})))
     (mapcat identity)
     (group-by identity)
     (vals)
     (map count)
     (reduce * 1))

(first (for [x input y input
             :when (->> (map = x y)
                        (remove identity)
                        count
                        (= 1))
             :let [diff (set/difference (set x) (set y))]]
         (str/join (remove diff x))))
