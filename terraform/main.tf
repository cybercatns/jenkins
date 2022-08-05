terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }
}

data "aws_instances" "web" {
  instance_tags = {
    Name = "WebServer"
  }
  instance_state_names = ["running"]
}

resource "aws_instance" "web" {
  ami           = "ami-0ff89c4ce7de192ea"
  instance_type = "t3.micro"
  key_name = "Jenkins"

  tags = {
    Name = "WebServer"
  }
}