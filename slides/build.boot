#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.0"

(set-env!
  :project      'simplicity-ws
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "2.2.1"]
                  [tailrecursion/hoplon      "5.10.9"]
                  [org.clojure/clojurescript "0.0-2202"]]
  :out-path     "resources/public"
  :src-paths    #{"src/cljs"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"resources/assets"})

(require '[tailrecursion.hoplon.boot :refer :all])

(deftask development
  "Build my-project for development."
  []
  (comp (watch) (hoplon {:prerender false :pretty-print true})))

(deftask production
  "Build my-project for production."
  []
  (hoplon {:optimizations :advanced}))
