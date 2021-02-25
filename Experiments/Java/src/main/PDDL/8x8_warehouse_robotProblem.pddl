(define (problem strips-robot)
    (:domain robot-strips)
    (:objects room_0_0 room_0_1 room_0_2 room_0_3 room_0_4 room_0_5 room_0_6 room_0_7 room_1_0 room_1_1 room_1_2 room_1_3 room_1_4 room_1_5 room_1_6 room_1_7 room_2_0 room_2_1 room_2_2 room_2_3 room_2_4 room_2_5 room_2_6 room_2_7 room_3_0 room_3_1 room_3_2 room_3_3 room_3_4 room_3_5 room_3_6 room_3_7 room_4_0 room_4_1 room_4_2 room_4_3 room_4_4 room_4_5 room_4_6 room_4_7 room_5_0 room_5_1 room_5_2 room_5_3 room_5_4 room_5_5 room_5_6 room_5_7 room_6_0 room_6_1 room_6_2 room_6_3 room_6_4 room_6_5 room_6_6 room_6_7 room_7_0 room_7_1 room_7_2 room_7_3 room_7_4 room_7_5 room_7_6 room_7_7 item )
    (:init (at room_0_0)
           (putlocation room_0_0)
           (connected room_0_0 room_0_1)
           (connected room_0_1 room_0_0)
           (connected room_0_1 room_0_2)
           (connected room_0_2 room_0_1)
           (connected room_0_2 room_0_3)
           (connected room_0_3 room_0_2)
           (connected room_0_3 room_0_4)
           (connected room_0_4 room_0_3)
           (connected room_0_4 room_0_5)
           (connected room_0_5 room_0_4)
           (connected room_0_5 room_0_6)
           (connected room_0_6 room_0_5)
           (connected room_0_6 room_0_7)
           (connected room_0_7 room_0_6)
           (connected room_1_0 room_1_1)
           (connected room_1_1 room_1_0)
           (connected room_1_1 room_1_2)
           (connected room_1_2 room_1_1)
           (connected room_1_2 room_1_3)
           (connected room_1_3 room_1_2)
           (connected room_1_3 room_1_4)
           (connected room_1_4 room_1_3)
           (connected room_1_4 room_1_5)
           (connected room_1_5 room_1_4)
           (connected room_1_5 room_1_6)
           (connected room_1_6 room_1_5)
           (connected room_1_6 room_1_7)
           (connected room_1_7 room_1_6)
           (connected room_2_0 room_2_1)
           (connected room_2_1 room_2_0)
           (connected room_3_0 room_3_1)
           (connected room_3_1 room_3_0)
           (connected room_3_1 room_3_2)
           (connected room_3_2 room_3_1)
           (connected room_3_2 room_3_3)
           (connected room_3_3 room_3_2)
           (connected room_3_3 room_3_4)
           (connected room_3_4 room_3_3)
           (connected room_3_4 room_3_5)
           (connected room_3_5 room_3_4)
           (connected room_3_5 room_3_6)
           (connected room_3_6 room_3_5)
           (connected room_3_6 room_3_7)
           (connected room_3_7 room_3_6)
           (connected room_4_0 room_4_1)
           (connected room_4_1 room_4_0)
           (connected room_4_1 room_4_2)
           (connected room_4_2 room_4_1)
           (connected room_4_2 room_4_3)
           (connected room_4_3 room_4_2)
           (connected room_4_3 room_4_4)
           (connected room_4_4 room_4_3)
           (connected room_4_4 room_4_5)
           (connected room_4_5 room_4_4)
           (connected room_4_5 room_4_6)
           (connected room_4_6 room_4_5)
           (connected room_4_6 room_4_7)
           (connected room_4_7 room_4_6)
           (connected room_5_0 room_5_1)
           (connected room_5_1 room_5_0)
           (connected room_6_0 room_6_1)
           (connected room_6_1 room_6_0)
           (connected room_6_1 room_6_2)
           (connected room_6_2 room_6_1)
           (connected room_6_2 room_6_3)
           (connected room_6_3 room_6_2)
           (connected room_6_3 room_6_4)
           (connected room_6_4 room_6_3)
           (connected room_6_4 room_6_5)
           (connected room_6_5 room_6_4)
           (connected room_6_5 room_6_6)
           (connected room_6_6 room_6_5)
           (connected room_6_6 room_6_7)
           (connected room_6_7 room_6_6)
           (connected room_7_0 room_7_1)
           (connected room_7_1 room_7_0)
           (connected room_7_1 room_7_2)
           (connected room_7_2 room_7_1)
           (connected room_7_2 room_7_3)
           (connected room_7_3 room_7_2)
           (connected room_7_3 room_7_4)
           (connected room_7_4 room_7_3)
           (connected room_7_4 room_7_5)
           (connected room_7_5 room_7_4)
           (connected room_7_5 room_7_6)
           (connected room_7_6 room_7_5)
           (connected room_7_6 room_7_7)
           (connected room_7_7 room_7_6)
           (connected room_0_0 room_1_0)
           (connected room_1_0 room_0_0)
           (connected room_1_0 room_2_0)
           (connected room_2_0 room_1_0)
           (connected room_2_0 room_3_0)
           (connected room_3_0 room_2_0)
           (connected room_3_0 room_4_0)
           (connected room_4_0 room_3_0)
           (connected room_4_0 room_5_0)
           (connected room_5_0 room_4_0)
           (connected room_5_0 room_6_0)
           (connected room_6_0 room_5_0)
           (connected room_6_0 room_7_0)
           (connected room_7_0 room_6_0)
           (connected room_0_1 room_1_1)
           (connected room_1_1 room_0_1)
           (connected room_1_1 room_2_1)
           (connected room_2_1 room_1_1)
           (connected room_2_1 room_3_1)
           (connected room_3_1 room_2_1)
           (connected room_3_1 room_4_1)
           (connected room_4_1 room_3_1)
           (connected room_4_1 room_5_1)
           (connected room_5_1 room_4_1)
           (connected room_5_1 room_6_1)
           (connected room_6_1 room_5_1)
           (connected room_6_1 room_7_1)
           (connected room_7_1 room_6_1)
           (connected room_0_2 room_1_2)
           (connected room_1_2 room_0_2)
           (connected room_3_2 room_4_2)
           (connected room_4_2 room_3_2)
           (connected room_6_2 room_7_2)
           (connected room_7_2 room_6_2)
           (connected room_0_3 room_1_3)
           (connected room_1_3 room_0_3)
           (connected room_3_3 room_4_3)
           (connected room_4_3 room_3_3)
           (connected room_6_3 room_7_3)
           (connected room_7_3 room_6_3)
           (connected room_0_4 room_1_4)
           (connected room_1_4 room_0_4)
           (connected room_3_4 room_4_4)
           (connected room_4_4 room_3_4)
           (connected room_6_4 room_7_4)
           (connected room_7_4 room_6_4)
           (connected room_0_5 room_1_5)
           (connected room_1_5 room_0_5)
           (connected room_3_5 room_4_5)
           (connected room_4_5 room_3_5)
           (connected room_6_5 room_7_5)
           (connected room_7_5 room_6_5)
           (connected room_0_6 room_1_6)
           (connected room_1_6 room_0_6)
           (connected room_3_6 room_4_6)
           (connected room_4_6 room_3_6)
           (connected room_6_6 room_7_6)
           (connected room_7_6 room_6_6)
           (connected room_0_7 room_1_7)
           (connected room_1_7 room_0_7)
           (connected room_3_7 room_4_7)
           (connected room_4_7 room_3_7)
           (connected room_6_7 room_7_7)
           (connected room_7_7 room_6_7)
    )
    (:goal (and )))