# pusher-dwares-code-challenge

container image link ==> `docker pull sarpreetsingh/pusher-dwarves-code-challenge`

## how to run

1. clone/download the repository
2. open the terminal, and `cd` into it
3. write `vagrant up`. This will run two instances of the container image. You can reach them by making *GET* requests:
    - First instance
        - 192.192.192.192/api/dwarves
        - 192.192.192.192/api/dwarves/{name}
    - Second instance
        - 193.193.193.193/api/dwarves
        - 193.193.193.193/api/dwarves/{name}