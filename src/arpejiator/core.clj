(ns arpejiator.core
  (use [overtone.live])
  (:require [overtone.studio.fx]
            [overtone.inst.synth]
            [overtone.inst.piano :refer [piano]]))

;;;;;;;;;;;;;;;;
;;  REMEMBER  ;;
;; (stop-all) ;;
;;;;;;;;;;;;;;;;


(defn get-note
  "Gets the note at a given position. If position is > count or less than
   0, instead transposes the note by the quotient"
  [notes position]
  (let [octave (quot position (count notes))
        origin-note (nth notes (mod position (count notes)))]
    (+ (* octave 12) origin-note)))

(defn chord-progression-beat
  "Creates a chord progression beat. 
   Common play-functions are instruments or midi out"
  [t freq arpeggio play-function notes]
  (let [position (first arpeggio)]
    (if (not (= :rest position))
      (at t (play-function (get-note notes position))))
    (let [next-t (+ t freq)
          next-arpeggio (conj (vec  (rest arpeggio)) position)]
      (println next-arpeggio)
      (apply-by next-t #'chord-progression-beat [next-t freq next-arpeggio play-function notes]))))

(comment
  "This is how you run an arpeggio with an instrument (piano)"
  (chord-progression-beat (now) 200 [0 1 0 2 0 3 -1 0 -2 0 -3] piano [60 67 64 71]))

(comment
  "This is how you run an arpeggio with the first midi out you have"
  (let [midi-play #(midi-note (first (midi-connected-receivers)) % 120 100)]
    (chord-progression-beat (now) 200 [0 1 0 2 0 3 -1 0 -2 0 -3] midi-play  [60 67 64 71])))
