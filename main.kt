//Define Task data type
data class task()

//Define Task Manager class w/ methods to add tasks and mark completed
class taskManager {
    fun addTask (name: String, dueDate: Date){

    }
    fun markCompleted {

    }
    fun sortByDate {

    }
}

//Run Task manager in console w/ user input
fun main(args: Array<String>) {
    taskManager = new taskManager;

    while (true)
    {
        //Write out new screen and show tasks by due date
        taskManager.sortByDate();
        foreach (task in taskManager)
            Console.Writeline(task + "\n");
        Console.WriteLine("menuoptions\n1: Add Task\n2:Mark Task Completed\n")
        //Query user for input

        //If input is 1, query for date and create new task
        //If input is 2, query for which task and delete it
    }
}
