package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

type Dwarf struct {
	Name    string `json:"name"`
	Birth   string `json:"birth"`
	Death   string `json:"death"`
	Culture string `json:"culture"`
}

type PusherAPIResponse struct {
	Dwarves []Dwarf
}

type DwarvesDTO struct {
	Dwarves []string `json:"dwarves"`
}

type DwarfDTO struct {
	Dwarf Dwarf `json:"dwarf"`
}

func fetchDwarves() []Dwarf {
	res, _ := http.Get("https://thedwarves.pusherplatform.io/api/dwarves")
	body, _ := ioutil.ReadAll(res.Body)
	apiRes := PusherAPIResponse{}
	json.Unmarshal(body, &apiRes)
	return apiRes.Dwarves
}

func findAllNames(res http.ResponseWriter, req *http.Request) {
	var dwarvesDto DwarvesDTO
	for _, dwarf := range fetchDwarves() {
		dwarvesDto.Dwarves = append(dwarvesDto.Dwarves, dwarf.Name)
	}
	data, _ := json.Marshal(dwarvesDto)
	res.Header().Set("Content-Type", "application-json")
	fmt.Println(string(data))
	res.Write(data)
}

func findByName(res http.ResponseWriter, req *http.Request) {
	res.Header().Set("Content-Type", "application-json")
	name := mux.Vars(req)["name"]
	for _, dwarf := range fetchDwarves() {
		if dwarf.Name == name {
			data, _ := json.Marshal(DwarfDTO{Dwarf{dwarf.Name, dwarf.Birth, dwarf.Death, dwarf.Culture}})
			res.Write(data)
			return
		}
	}
	res.Write([]byte(`{"message": "no dwarf found"}`))
}

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/api/dwarves", findAllNames).Methods("GET")
	router.HandleFunc("/api/dwarves/{name}", findByName).Methods("GET")
	log.Fatal(http.ListenAndServe(":8080", router))
}
