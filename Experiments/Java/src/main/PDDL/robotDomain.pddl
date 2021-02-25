(define (domain robot-strips)
  (:predicates (at ?r) (connected ?r1 ?r2) (holding ?i) (itemat ?i ?r) (putlocation ?r) )
  (:action move
   :parameters (?from ?to)
   :precondition (and (at ?from)
                      (connected ?from ?to))
   :effect (and (not (at ?from))
                (at ?to)))
  (:action pickup
      :parameters (?room ?item)
      :precondition (and (itemat ?item ?room)
                    (at ?room))
      :effect (and (holding ?item)
                    (not (itemat ?item ?room)))
  )
  (:action put
      :parameters (?room ?item)
      :precondition (and (putlocation ?room)
                    (at ?room)
                    (holding ?item))
      :effect (and (itemat ?item ?room)
                    (not (holding ?item)))
  )
)