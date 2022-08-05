output "private_ip" {
description = "Private IP of the web server"
value       = aws_instance.web.private_ip
}

resource "local_file" "ansible_inventory" {
  content = templatefile("inventory.tmpl", {
    webserver_ip = "${aws_instance.web.private_ip}"
  })
  filename = "inventory"
}

