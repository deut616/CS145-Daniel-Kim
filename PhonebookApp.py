class Contact:
    def __init__(self, name, phone):
        self.name = name
        self.phone = phone
        self.next = None

class PhoneBook:
    def __init__(self):
        self.head = None

    def add(self, name, phone):
        new_node = Contact(name, phone)
        
        # Handle empty list case
        if not self.head:
            self.head = new_node
            return

        # Navigate to the end of the chain to append
        curr = self.head
        while curr.next:
            curr = curr.next
        curr.next = new_node

    def show(self):
        curr = self.head
        if not curr:
            print("No contacts.")
            return
            
        while curr:
            print(f"{curr.name}: {curr.phone}")
            curr = curr.next

# Test it
pb = PhoneBook()
pb.add("Felix", "111-2200")
pb.add("Obama", "333-4489")
pb.add("Daniel", "253-6645")
pb.show()