@FilterDef(name = "paperFilter", parameters = {
        @ParamDef(name = "title", type = "String"),
        @ParamDef(name = "description", type = "String"),
        @ParamDef(name = "division", type = "String"),
        @ParamDef(name = "institute", type = "String"),
        @ParamDef(name = "isPaid", type = "String"),
        @ParamDef(name = "withPartner", type = "boolean")
})

package com.masterarbeitsboerse.masterarbeitsboerse;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


