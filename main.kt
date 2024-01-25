//Define Task data type
data class Task(val name: String) {
    private var _id: Int = 0
    var taskName = name
    var id: Int
        get() = _id
        private set(value) {
            _id = value
        }
    init {
        _id++
    }
    fun get_id(): Int {
        return id
    }
}


//Define Task Manager class w/ methods to add tasks and mark completed
class taskManager() {
    val taskList = mutableListOf<Task>()
    fun listTasks() {
        for (task in taskList)
            println(task.get_id())
    }
    fun addTask (name: String){
        val task = Task(name)
    }
    fun setTaskName(): String {
        print("Task name: ")
        val name :String = try {
            readLine().toString()
        } catch (e: Exception) {
            println("Invalid Entry")
            setTaskName()
        }
        return name
    }
}

//Run Task manager in console w/ user input
fun main(args: Array<String>) {
    val taskManager = taskManager()

    while (true) {
        //Write out tasks for user to view
        taskManager.listTasks()

        //Query user for input
        println("Menu Options\n1: Add Task\n2:Mark Task Completed")
        val input = readLine()!!.toInt()

        //If input is 1, create new task, if 2 delete a task
        if (input == 1)
        {
            taskManager.addTask(taskManager.setTaskName())
        } else if (input == 2) {

        } else {
            println("Invalid Entry")
        }
        //If input is 2, query for which task and delete it

    }

}
