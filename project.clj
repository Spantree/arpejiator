(defproject arpejiator "0.1.0-SNAPSHOT"
  :description "Make and play arpeggios with overtone"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [overtone "0.9.1"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
