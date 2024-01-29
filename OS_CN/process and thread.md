Process and Threads
    what is process
    what is thread
    difference
    thread lifecycle in java
        5 stages
            1. new -> when new instance of thread is created
            2. runnable -> ready to run (once you invoke the method start, thread enters the runnable state and will be considered for execution by os)
            3. running -> thread is in execution state
            4. waiting/sleeping/blocked -> during it's execution thread might be paused due to some reasons, such as waiting for lock..
            5. terminated/interuptted -> when the run method of thread completes it's execution/when thread execution stopped due to an inturup 
Executors and callables
Locks and synchronization