package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.role.entity.RoleFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AclFactoryTest {

    @Test
    public void test() {
        ArrayList<Acl> guestRole = (ArrayList<Acl>) ((Collection<Acl>)AclFactory.createGuestRole(RoleFactory.guestRole()));

        System.out.println(Arrays.toString(guestRole.toArray()));

        guestRole.addAll(AclFactory.createGuestRole(RoleFactory.guestRole()));

        System.out.println(Arrays.toString(guestRole.toArray()));
    }
}