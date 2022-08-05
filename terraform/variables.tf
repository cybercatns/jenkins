variable "network_interface_id" {
  type = string
  default = "network_id_from_aws"
}

variable "ami" {
    type = string
    default = "ami-0ff89c4ce7de192ea"
}

variable "instance_type" {
    type = string
    default = "t2.micro"
}