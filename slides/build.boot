#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.0"

(set-env!
  :project      'simplicity-ws
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "2.2.1"]
                  [tailrecursion/hoplon      "5.10.12"]
                  [tailrecursion/boot.ring   "0.2.1"]
                  [tailrecursion/boot.notify "2.0.2"]]
  :out-path     "resources/public"
  :src-paths    #{"src/cljs"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"resources/assets"})

(require '[tailrecursion.boot.task :refer :all]
         '[tailrecursion.hoplon.boot :refer :all]
         '[tailrecursion.boot.task.notify :refer [hear]]
         '[tailrecursion.boot.task.ring :refer [dev-server]])

(deftask development
  "Build my-project for development."
  []
  (comp (watch)        
        (hoplon {:prerender false :pretty-print true})
        (dev-server)))

(deftask production
  "Build my-project for production."
  []
  (hoplon {:optimizations :advanced}))
