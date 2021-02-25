(define (problem strips-robot)
    (:domain robot-strips)
    (:objects room_0_0 room_0_1 room_0_2 room_0_3 room_0_4 room_1_0 room_1_1 room_1_2 room_1_3 room_1_4 room_2_0 room_2_1 room_2_2 room_2_3 room_2_4 room_3_0 room_3_1 room_3_2 room_3_3 room_3_4 room_4_0 room_4_1 room_4_2 room_4_3 room_4_4)
    (:init (at room_0_0)
           (connected room_0_0 room_0_1)
           (connected room_0_1 room_0_0)
           (connected room_0_1 room_0_2)
           (connected room_0_2 room_0_1)
           (connected room_0_2 room_0_3)
           (connected room_0_3 room_0_2)
           (connected room_0_3 room_0_4)
           (connected room_0_4 room_0_3)
           (connected room_1_0 room_1_1)
           (connected room_1_1 room_1_0)
           (connected room_1_1 room_1_2)
           (connected room_1_2 room_1_1)
           (connected room_1_2 room_1_3)
           (connected room_1_3 room_1_2)
           (connected room_1_3 room_1_4)
           (connected room_1_4 room_1_3)
           (connected room_2_0 room_2_1)
           (connected room_2_1 room_2_0)
           (connected room_2_1 room_2_2)
           (connected room_2_2 room_2_1)
           (connected room_2_2 room_2_3)
           (connected room_2_3 room_2_2)
           (connected room_2_3 room_2_4)
           (connected room_2_4 room_2_3)
           (connected room_3_0 room_3_1)
           (connected room_3_1 room_3_0)
           (connected room_3_1 room_3_2)
           (connected room_3_2 room_3_1)
           (connected room_3_2 room_3_3)
           (connected room_3_3 room_3_2)
           (connected room_3_3 room_3_4)
           (connected room_3_4 room_3_3)
           (connected room_4_0 room_4_1)
           (connected room_4_1 room_4_0)
           (connected room_4_1 room_4_2)
           (connected room_4_2 room_4_1)
           (connected room_4_2 room_4_3)
           (connected room_4_3 room_4_2)
           (connected room_4_3 room_4_4)
           (connected room_4_4 room_4_3)
           (connected room_0_0 room_1_0)
           (connected room_1_0 room_0_0)
           (connected room_1_0 room_2_0)
           (connected room_2_0 room_1_0)
           (connected room_2_0 room_3_0)
           (connected room_3_0 room_2_0)
           (connected room_3_0 room_4_0)
           (connected room_4_0 room_3_0)
           (connected room_0_1 room_1_1)
           (connected room_1_1 room_0_1)
           (connected room_1_1 room_2_1)
           (connected room_2_1 room_1_1)
           (connected room_2_1 room_3_1)
           (connected room_3_1 room_2_1)
           (connected room_3_1 room_4_1)
           (connected room_4_1 room_3_1)
           (connected room_0_2 room_1_2)
           (connected room_1_2 room_0_2)
           (connected room_1_2 room_2_2)
           (connected room_2_2 room_1_2)
           (connected room_2_2 room_3_2)
           (connected room_3_2 room_2_2)
           (connected room_3_2 room_4_2)
           (connected room_4_2 room_3_2)
           (connected room_0_3 room_1_3)
           (connected room_1_3 room_0_3)
           (connected room_1_3 room_2_3)
           (connected room_2_3 room_1_3)
           (connected room_2_3 room_3_3)
           (connected room_3_3 room_2_3)
           (connected room_3_3 room_4_3)
           (connected room_4_3 room_3_3)
           (connected room_0_4 room_1_4)
           (connected room_1_4 room_0_4)
           (connected room_1_4 room_2_4)
           (connected room_2_4 room_1_4)
           (connected room_2_4 room_3_4)
           (connected room_3_4 room_2_4)
           (connected room_3_4 room_4_4)
           (connected room_4_4 room_3_4))
    (:goal (and )))