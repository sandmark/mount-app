(ns dev
  (:require [clojure.java.io :as io]
            [clojure.repl :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.tools.namespace.repl :refer [refresh]]
            [mount.core :as mount]
            [orchestra.spec.test :as stest]))

(clojure.tools.namespace.repl/set-refresh-dirs "dev/src" "src" "test" "spec")

(defn start []
  (stest/instrument)
  (mount/start))

(defn stop []
  (stest/unstrument)
  (mount/stop))

(defn reset []
  (stop)
  (refresh :after 'mount.core/start)
  (stest/instrument))

(stest/instrument)
