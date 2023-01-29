(ns {{name}}.core
    (:require [mount.core :as mount :refer [defstate]])
    (:gen-class))

(defstate env
  :start {:options {}})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
