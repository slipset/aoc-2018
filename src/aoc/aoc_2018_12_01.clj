(ns aoc.aoc-2018-12-01
  (:require [clojure.string :as str]))

(defn input []
  (->> "resources/input-2018-12-01.txt"
       slurp
       str/split-lines
       (map read-string)))

(reduce + (input))

(->> (input)
     repeat
     flatten
     (reduce (fn [{:keys [seen freq] :as acc} n]
               (let [new-freq (+ freq n)]
                 (if (seen new-freq)
                   (reduced new-freq)
                   {:seen (conj seen new-freq)
                    :freq new-freq}))) {:seen #{}
                                        :freq 0}))
