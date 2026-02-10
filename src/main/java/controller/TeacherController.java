import java.util.*;
public class TeacherController {
        private List<Teacher> teachers;

        public TeacherController() {
            this.teachers = new ArrayList<>();
        }

        public void addTeacher(Teacher teacher) {
            teachers.add(teacher);
        }

        public List<Teacher> getAllTeachers() {
            return teachers;
        }

        public Teacher getTeacherById(String id) {
            for (Teacher teacher : teachers) {
                if (teacher.getId().equals(id)) {
                    return teacher;
                }
            }
            return null; // or throw an exception
        }

        public void updateTeacher(String id, Teacher updatedTeacher) {
            for (int i = 0; i < teachers.size(); i++) {
                if (teachers.get(i).getId().equals(id)) {
                    teachers.set(i, updatedTeacher);
                    return;
                }
            }
            // Handle case where teacher is not found
        }

        public void deleteTeacher(String id) {
            teachers.removeIf(teacher -> teacher.getId().equals(id));
        }
}
