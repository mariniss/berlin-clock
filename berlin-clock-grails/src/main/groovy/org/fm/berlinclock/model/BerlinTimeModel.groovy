package org.fm.berlinclock.model;

class BerlinTimeModel {
   Boolean   clockTwoSeconds
   Boolean[] hoursPerFive
   Boolean[] hoursPerOne
   Boolean[] minutesPerFive
   Boolean[] minutesPerOne

    BerlinTimeModel() {
       this.clockTwoSeconds = false
       this.hoursPerFive    = [false, false, false, false]
       this.hoursPerOne     = [false, false, false, false]
       this.minutesPerFive  = [false, false, false, false, false, false, false, false, false, false, false]
       this.minutesPerOne   = [false, false, false, false]
   }
}
