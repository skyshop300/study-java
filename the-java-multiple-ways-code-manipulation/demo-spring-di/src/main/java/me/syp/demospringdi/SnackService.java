package me.syp.demospringdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackService {

    @Autowired
    SnackRepository snackRepository;

}