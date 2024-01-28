import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.FileReader
import  java.io.BufferedReader
import kotlin.collections.List

//Define Task data type
data class Task(val name: String, val id: Int) {
    var _id: Int = id
    var taskName = name
}

//Define Task Manager class w/ methods to add tasks and mark completed
class taskManager() {
    //Create variables and objects
    val taskList = mutableListOf<Task>()
    var id: Int = 1
    val file = File("tasks.txt")

    //Creates an object to read from a file, then creates a list of strings from each line of the file. Adds each line as a new task
    fun readTasksFromFile() {
        BufferedReader(FileReader(file)).use { reader ->
            val taskNames = reader.readLines()
            for (i in 1..taskNames.count())
            {
                addTask(taskNames[i-1])
            }
        }
    }

    //Creates a writer object and then, using the passed list, writes each item in the list as a line in the file
    fun writeTasksToFile(taskList: List<Task>) {
        BufferedWriter(FileWriter(file)).use { writer ->
            for (i in 1.. taskList.count()) {
                writer.write(taskList[i-1].taskName)
                writer.newLine()
            }
        }

        println("Tasks saved successfully!")
    }

    //Displays all tasks to user
    fun listTasks() {
        println("\nTasks:")
        for (i in 0 .. taskList.count()-1) {
            println(taskList[i]._id.toString() + ": " + taskList[i].taskName)
        }

    }

    //Creates a new task and increments the ID
    fun addTask (name: String){
        val task = Task(name, id)
        taskList.add(task)
        id++
    }

    //Reads the input from user and returns the input as a string
    fun setTaskName(): String {
        print("Task name: ")
        val name :String = readLine()!!.toString()
        return name
    }

    //Removes a task at a given index derived from the id given from the user
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
    //Initialize task manager object and read tasks from file
    val taskManager = taskManager()
    taskManager.readTasksFromFile()

    var going = true
    while (going) {
        //Write out tasks for user to view
        taskManager.listTasks()

        //Query user for input
        print("Menu Options\n1) Add Task\n2) Mark Task Completed\n3) Exit\n> ")
        val input = readLine()!!.toInt()

        //If input is 1, create new task, if 2 delete a task, if 3 save to file and exit
        if (input == 1)
        {
            taskManager.addTask(taskManager.setTaskName())
            println("Task Added!")
        } else if (input == 2) {
            taskManager.deleteTask()
        } else if (input == 3){
            going = false
            println("Goodbye!")
            taskManager.writeTasksToFile(taskManager.taskList)
        } else {
            println("Invalid Entry")
        }
    }
}