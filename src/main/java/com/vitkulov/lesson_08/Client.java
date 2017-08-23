package com.vitkulov.lesson_08;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private List<Pet> petList;

    public Client() {
        this.petList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public void addPet(Pet pet) {
        petList.add(pet);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petList=" + petList +
                '}';
    }

    public Pet getPetById(int petId) {
        Pet result = null;
        for (Pet pet : petList) {
            if (pet.getId() == petId) {
                result = pet;
                break;
            }
        }
        return result;
    }

    public void editPet(Pet pet) {
        petList.remove(this.getPetById(pet.getId()));
        petList.add(pet);
    }

    public void deletePet(int petId) {
        petList.remove(this.getPetById(petId));
    }
}
