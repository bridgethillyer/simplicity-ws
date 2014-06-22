(defproject hoplon-reveal-js "0.2.0-SNAPSHOT"
  :description "Reveal.js for Hoplon"
  :url "http://github.com/oubiwann/hoplon-reveal-js"
  :license {:name "Apache V2 License"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [http-kit "2.1.16"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [org.clojure/clojurescript "0.0-2138"]]
  :source-paths ["src/clj"]
  :jvm-opts ^:replace ["-Xmx512m" "-server"]
  :aot [devserver]
  :main devserver/run)
