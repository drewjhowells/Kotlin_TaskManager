//Define Task data type
data class Task(val name: String, val id: Int) {
    var _id: Int = id
    var taskName = name
}


//Define Task Manager class w/ methods to add tasks and mark completed
class taskManager() {
    val taskList = mutableListOf<Task>()
    var id: Int = 1

    fun listTasks() {
        println("\nTasks:")
        for (i in 0 .. taskList.count()-1) {
            println(taskList[i]._id.toString() + ": " + taskList[i].taskName)
        }

    }

    fun addTask (name: String){
        val task = Task(name, id)
        taskList.add(task)
        id++
    }
    fun setTaskName(): String {
        print("Task name: ")
        val name :String = readLine()!!.toString()
        return name
    }

    fun deleteTask() {
        print("Task ID: ")
        val task_id :Int = readLine()!!.toInt()
        taskList.removeAt(task_id-1)
        println("Task Deleted!")
        for (i in task_id-1 .. taskList.count()-1) {
            taskList[i]._id --
        }
        id--
    }

}

//Run Task manager in console w/ user input
fun main(args: Array<String>) {
    val taskManager = taskManager()
    var going = true
    while (going) {
        //Write out tasks for user to view
        taskManager.listTasks()

        //Query user for input
        print("Menu Options\n1) Add Task\n2) Mark Task Completed\n3) Exit\n> ")
        val input = readLine()!!.toInt()

        //If input is 1, create new task, if 2 delete a task, if 3 exit
        if (input == 1)
        {
            taskManager.addTask(taskManager.setTaskName())
            println("Task Added!")
        } else if (input == 2) {
            taskManager.deleteTask()
        } else if (input == 3){
            going = false
            println("Goodbye!")
        } else {
            println("Invalid Entry")
        }
    }
}
