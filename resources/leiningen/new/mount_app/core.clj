(ns {{name}}.core
    (:require [mount.core :as m])
    (:gen-class))

(m/defstate env
  :start {:options {}})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
