(ns git-folder.core
  (:gen-class)
  (:require [clojure.java.shell :refer [sh]]
            [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as str]))



(def cli-options
  ;; An option with a required argument
  [[nil "--url url" "GitHub.com folder URL"
    :validate [#(not-empty %) "URL can´t be empty"]]
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])


(defn download-folder [url]
  (println  "donw f " url)
  (let [{out :out  err :err} (sh "svn" "checkout" (str/replace url #"tree/\w+/" "/trunk/"))]
    (println out err))
  )


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
    (let [{:keys [options summary errors]} (parse-opts args cli-options)
        url (get options :url)]
    (if (or errors (nil? url))
      (do (run! println errors) (println summary))
      (download-folder url)))
  (System/exit 0)) 







                             


