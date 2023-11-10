package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

//@Entity
//@Table(name = "STATUSTYPE")
public enum StatusType {
    pending,
    ordered,
    canceled
}
