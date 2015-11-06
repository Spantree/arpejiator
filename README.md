# arpejiator

This is an overtone project to create cool arpeggios.

## Usage

The one function you need is aprejiator.core/arpeggio

Call this with a time (usually now), a frequency, an arpeggio sequence, a play-function, and a list of notes.

An arpeggio sequence is a vector of positions to play. For example, if you just wanted to go up and down a three note chord, you would set [0 1 2 1] as your arpeggio sequence.

Notes is a vector of midi notes, e.g. [60 67 64 71] refers to C4 Major7. I'd strongly encourage you to look up other interesting chords with overtone's `chord` method.

## License

Copyright © 2015 Spantree
