#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.0"

(set-env!
  :project
  'hoplon-reveal-js
  :version
  "0.2.0-SNAPSHOT"
  :dependencies
  [['tailrecursion/boot.core "2.5.0"]
   ['tailrecursion/boot.task "2.2.1"]
   ['tailrecursion/hoplon "5.10.8"]
   ['org.clojure/clojurescript "0.0-2234"]]
  :src-paths
  #{"src/cljs"}
  :out-path
  "resources/public")

(add-sync! (get-env :out-path) #{"resources/assets"})

(require
  ['tailrecursion.hoplon.boot :refer :all]
  ['tailrecursion.boot.task :refer :all])
