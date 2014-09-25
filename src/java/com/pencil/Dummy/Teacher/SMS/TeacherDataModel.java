/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Teacher.SMS;

import com.pencil.Dummy.Teacher.Teacher;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author jahangiralamdiu
 */
public class TeacherDataModel extends ListDataModel<Teacher> implements SelectableDataModel<Teacher> {

    /**
     *
     */
    public TeacherDataModel() {
    }

    /**
     *
     * @param list
     */
    public TeacherDataModel(List<Teacher> list) {
        super(list);
    }

    /**
     *
     * @param mobile
     * @return
     */
    @Override
    public Teacher getRowData(String mobile)
    {
        List<Teacher> teaherData = (List<Teacher>) getWrappedData();

        for (Teacher teacher : teaherData) {
            if (teacher.getContactNo().equals(mobile)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     *
     * @param teacher
     * @return
     */
    @Override
    public Object getRowKey(Teacher teacher)
    {
        return teacher.getContactNo();
    }

}
