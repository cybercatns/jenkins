terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }
}

resource "aws_instance" "web" {
  ami           = "ami-0ff89c4ce7de192ea"
  instance_type = "t3.micro"
  key_name = "Jenkins"

  tags = {
    Name = "HelloWorld"
  }
}