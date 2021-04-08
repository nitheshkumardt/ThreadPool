# ThreadPool

AbortPolicy()-->Throws Error
DiscardPolicy()-->Remove the Rejection tasks
DiscardOldestPolicy()-->first removes a task from the head of the queue, then re-submits the new task
CallerRunsPolicy()-->makes the caller thread execute the task(asynchronouse)
Custom-->we put the task in Queue
