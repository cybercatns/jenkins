resource "local_file" "ansible_inventory" {
  content = templatefile("inventory.tmpl", {
    webserver_ip = data.aws_instances.test.private_ips,
  })
  filename = "inventory"
}

