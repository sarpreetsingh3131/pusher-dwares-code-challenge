Vagrant.configure("2") do |config|
  config.vm.define "server1" do |server1|
    server1.vm.box = "bento/ubuntu-18.04"
    server1.vm.network "private_network", ip: "11.11.11.11"
    server1.vm.provision "shell", inline: <<-SHELL
    sudo apt-get update
    sudo apt-get install -y docker.io
    sudo docker pull sarpreetsingh/pusher-dwarves-code-challenge
    sudo docker run -d -p 80:8080 sarpreetsingh/pusher-dwarves-code-challenge
  SHELL
  end
  config.vm.define "server2" do |server2|
    server2.vm.box = "bento/ubuntu-18.04"
    server2.vm.network "private_network", ip: "22.22.22.22"
    server2.vm.provision "shell", inline: <<-SHELL
    sudo apt-get update
    sudo apt-get install -y docker.io
    sudo docker pull sarpreetsingh/pusher-dwarves-code-challenge
    sudo docker run -d -p 80:8080 sarpreetsingh/pusher-dwarves-code-challenge
  SHELL
  end
end
