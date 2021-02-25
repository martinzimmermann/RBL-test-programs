(define (problem strips-robot)
    (:domain robot-strips)
    (:objects room_0_0 room_0_1 room_0_2 room_1_0 room_1_1 room_1_2 room_2_0 room_2_1 room_2_2 )
    (:init (at room_0_0)
           (connected room_0_0 room_0_1)
           (connected room_0_1 room_0_0)
           (connected room_0_1 room_0_2)
           (connected room_0_2 room_0_1)
           (connected room_1_0 room_1_1)
           (connected room_1_1 room_1_0)
           (connected room_1_1 room_1_2)
           (connected room_1_2 room_1_1)
           (connected room_2_0 room_2_1)
           (connected room_2_1 room_2_0)
           (connected room_2_1 room_2_2)
           (connected room_2_2 room_2_1)
           (connected room_0_0 room_1_0)
           (connected room_1_0 room_0_0)
           (connected room_1_0 room_2_0)
           (connected room_2_0 room_1_0)
           (connected room_0_1 room_1_1)
           (connected room_1_1 room_0_1)
           (connected room_1_1 room_2_1)
           (connected room_2_1 room_1_1)
           (connected room_0_2 room_1_2)
           (connected room_1_2 room_0_2)
           (connected room_1_2 room_2_2)
           (connected room_2_2 room_1_2)
    )
    (:goal (and )))