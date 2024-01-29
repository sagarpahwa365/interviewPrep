cpu scheduling algos
    SRTF (shortest response time first)
        issue: starvation for large tasks
    Round Robin (works on time quanta - predefined)
        1. Assume time-quanta q = 2ns i.e. if we have multiple tasks waiting for cpu.
            then, each task will execute for 1 quanta in round robin fashion
        2. Uses a queue to maintain tasks. 
        3. Execute first task for q time or till completion (whichever is short duration), 
            and if it is still pending, push it to end of queue.

    ----------------------------------------
    PID     Time of Arrival     Burst Time
    ----------------------------------------
    1       1                   5
    2       2                   3
    3       3                   1
    4       3                   8
    5       4                   7
    6       5                   6







