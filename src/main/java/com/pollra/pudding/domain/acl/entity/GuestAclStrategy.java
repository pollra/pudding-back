package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.role.entity.AuthorityCode;

import java.util.ArrayList;
import java.util.List;

public class GuestAclStrategy implements AclStrategy{
    @Override
    public List<Acl> apply(AuthorityCode code) {
        List<Acl> acls = new ArrayList<>();
        return null;
    }
}
