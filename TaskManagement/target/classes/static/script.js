const taskForm = document.getElementById('taskForm');
const taskList = document.getElementById('taskList');

// Function to fetch tasks from backend and render on UI
async function fetchTasks() {
    try {
        const response = await fetch('/task');
        if (!response.ok) {
            throw new Error('Failed to fetch tasks');
        }
        const tasks = await response.json();
        taskList.innerHTML = ''; // Clear existing task list
        tasks.forEach(task => {
            const taskRow = createTaskRow(task.id, task.title, task.description, task.status);
            taskList.appendChild(taskRow);
        });
    } catch (error) {
        console.error('Error fetching tasks:', error);
    }
}

// Event listener for form submission
taskForm.addEventListener('submit', async function(event) {
    event.preventDefault();
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;
    const status = document.getElementById('status').value;

    const formData = {
        title: title,
        description: description,
        status: status
    };

    try {
        const response = await fetch('/task', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });
        if (!response.ok) {
            throw new Error('Failed to add task');
        }
        const task = await response.json();
        const taskRow = createTaskRow(task.id, task.title, task.description, task.status);
        taskList.appendChild(taskRow);
        taskForm.reset();
    } catch (error) {
        console.error('Error adding task:', error);
    }
});

// Function to create a task row in the table
function createTaskRow(id, title, description, status) {
    const taskRow = document.createElement('tr');
    taskRow.innerHTML = `
        <td>${id}</td>
        <td>${title}</td>
        <td>${description}</td>
        <td>${status}</td>
        <td><button class="complete-btn">Mark Complete</button></td>
        <td><button class="edit-btn">Edit</button></td>
        <td><button class="delete-btn">Delete</button></td>
    `;

    // Add event listener for delete button
    const deleteBtn = taskRow.querySelector('.delete-btn');
    deleteBtn.addEventListener('click', async function() {
        try {
            const response = await fetch(`/task/${id}`, {
                method: 'DELETE'
            });
            if (!response.ok) {
                throw new Error('Failed to delete task');
            }
            taskRow.remove();
        } catch (error) {
            console.error('Error deleting task:', error);
        }
    });

    // Add event listener for edit button
    const editBtn = taskRow.querySelector('.edit-btn');
    editBtn.addEventListener('click', async function() {
        const newTitle = prompt('Enter new title:', title);
        const newDescription = prompt('Enter new description:', description);
        const newStatus = prompt('Enter new status (Pending, In Progress, Completed):', status);

        if (newTitle !== null && newTitle !== '' &&
            newDescription !== null && newStatus !== null) {
            const newData = {
                title: newTitle,
                description: newDescription,
                status: newStatus
            };

            try {
                const response = await fetch(`/task/${id}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(newData)
                });
                if (!response.ok) {
                    throw new Error('Failed to update task');
                }
                // Update the task row in UI with the new values
                taskRow.children[1].textContent = newTitle;
                taskRow.children[2].textContent = newDescription;
                taskRow.children[3].textContent = newStatus;
            } catch (error) {
                console.error('Error updating task:', error);
            }
        }
    });

    // Add event listener for complete button
    const completeBtn = taskRow.querySelector('.complete-btn');
    completeBtn.addEventListener('click', async function() {
        try {
            const newData = {
                status: 'Completed'
            };
            const response = await fetch(`/task/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newData)
            });
            if (!response.ok) {
                throw new Error('Failed to complete task');
            }
            taskRow.children[3].textContent = 'Completed';
        } catch (error) {
            console.error('Error completing task:', error);
        }
    });

    return taskRow;
}

// Fetch tasks when the page loads
fetchTasks()
