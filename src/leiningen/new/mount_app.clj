(ns leiningen.new.mount-app
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "mount-app"))

(defn mount-app
  "Generates mount based REPL driven template"
  [name]
  (let [data {:name      name
              :sanitized (tmpl/name-to-path name)}]
    (main/info (str "Creating new reloadable project using mount called \"" name "\" ..."))
    (tmpl/->files data
                  "resources"
                  ["spec/{{sanitized}}/core_spec.clj" (render "core_spec.clj" data)]
                  [".dir-locals.el" (render "dir-locals.el" data)]
                  ["dev/src/user.clj" (render "user.clj" data)]
                  ["dev/src/dev.clj" (render "dev.clj" data)]
                  ["README.md" (render "README.md" data)]
                  ["LICENSE" (render "LICENSE" data)]
                  [".gitignore" (render "gitignore" data)]
                  ["test/{{sanitized}}/core_test.clj" (render "test.clj" data)]
                  ["project.clj" (render "project.clj" data)]
                  ["profiles.clj" (render "profiles.clj" data)]
                  ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
