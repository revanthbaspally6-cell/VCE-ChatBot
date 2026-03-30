package vasavichatbot;

import java.util.*;
import vasavichatbot.models.Faculty;

public class BotLogic {

    public static String getResponse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "I did not receive any message from you. Please type your question, such as asking about admissions, fees, departments, placements, faculty details, or general information about Vasavi College of Engineering.";
        }

        input = input.toLowerCase().trim();

        if (contains(input, "help", "what can you do", "options", "menu", "commands")) {
            return "I am the Vasavi College Chatbot. Here are some example questions you can ask me:\n\n"
                    + "1) College Overview:\n"
                    + "   • about college\n"
                    + "   • about vce\n"
                    + "   • tell me about vasavi college\n\n"
                    + "2) Location and Contact:\n"
                    + "   • college address\n"
                    + "   • where is college located\n"
                    + "   • contact details\n"
                    + "   • college phone number\n"
                    + "   • principal email id\n\n"
                    + "3) Branches and Departments:\n"
                    + "   • what are the departments\n"
                    + "   • branches available\n"
                    + "   • cse department info\n"
                    + "   • it department details\n"
                    + "   • ece department details\n"
                    + "   • eee / civil / mechanical department info\n\n"
                    + "4) Fees and Admissions:\n"
                    + "   • fee structure\n"
                    + "   • how much is the college fee\n"
                    + "   • admission process\n"
                    + "   • how to join vce\n"
                    + "   • rank required for cse or it\n\n"
                    + "5) Placements and Training:\n"
                    + "   • placement details\n"
                    + "   • highest package\n"
                    + "   • average package\n"
                    + "   • companies visiting college\n\n"
                    + "6) Academics and Exams:\n"
                    + "   • syllabus or curriculum\n"
                    + "   • exam timetable\n"
                    + "   • exam dates\n"
                    + "   • attendance rules\n"
                    + "   • how to calculate gpa and cgpa\n\n"
                    + "7) Facilities and Campus Life:\n"
                    + "   • library timings\n"
                    + "   • lab facilities\n"
                    + "   • canteen and food\n"
                    + "   • hostels or accommodation\n"
                    + "   • transport and bus facility\n\n"
                    + "8) Student Activities and Support:\n"
                    + "   • student clubs and technical clubs\n"
                    + "   • fests and events\n"
                    + "   • anti ragging and grievance support\n"
                    + "   • discipline rules and code of conduct\n\n"
                    + "9) Faculty and Departments:\n"
                    + "   • faculty ramesh\n"
                    + "   • faculty sravani\n"
                    + "   • cse faculty list\n"
                    + "   • ece faculty list\n\n"
                    + "You can type your question in simple English, and I will try to give you a clear and detailed answer related to Vasavi College of Engineering.";
        }

        if (contains(input, "hello", "hi", "hey", "hlo", "good morning", "good afternoon", "good evening", "namaste")) {
            return "Hello, and welcome to the Vasavi College Chatbot. I am here to guide you with detailed information about the college.";
        }

        if (contains(input, "about college", "about vce", "college info", "tell me about vce", "about vasavi")) {
            return "Vasavi College of Engineering (VCE) is an autonomous, self-financing institution located in Ibrahimbagh, Hyderabad. It is affiliated to Osmania University and is known for its strong academic culture, disciplined environment, and student-centered learning atmosphere. The college offers undergraduate and postgraduate programs in various engineering disciplines, with a focus on conceptual clarity, hands-on laboratory experience, and industry-oriented learning. The campus has well-equipped laboratories, a rich central library, experienced and approachable faculty, strong placement support, and active student clubs that encourage both technical and cultural growth. The institution emphasizes continuous internal evaluation, regular assessments, mentoring, and skill development programs to prepare students for both higher studies and professional careers.";
        }

        if (contains(input, "location", "where is college", "address", "how to reach", "college located")) {
            return "Vasavi College of Engineering is located at Ibrahimbagh, Hyderabad, Telangana, with the PIN code 500031. It is situated near the historic Golconda Fort and can be reached easily from major areas such as Mehdipatnam, Tolichowki, Gachibowli, and Hitech City. The campus is away from heavy city traffic and provides a calm and academically focused environment. Public transport, RTC buses, and college buses are available from different parts of the city, making it convenient for day scholars to commute.";
        }

        if (contains(input, "contact", "phone number", "email id", "contact details", "office number")) {
            return "You can contact Vasavi College of Engineering through the following official channels:\n\nPhone (Main Office): 040-23146003\nAdditional Contact: Please refer to the official contact page for updated numbers.\nEmail (Principal): principal@vce.ac.in\nGeneral Queries: info@vce.ac.in, if specified on the official website.\nOfficial Website: https://vce.ac.in/\n\nFor admissions, examinations, and placement-specific queries, you are advised to check the respective sections on the website or call the administrative office during working hours. It is always better to verify timings and availability before visiting in person.";
        }

        if (contains(input, "website", "official website", "college site")) {
            return "The official website of Vasavi College of Engineering is https://vce.ac.in/ . The website provides detailed and updated information about admissions, academic regulations, syllabi, examination timetables, results notifications, placement statistics, circulars, and contact details. You can also access department-wise pages, faculty lists, and important forms. It is recommended to regularly visit the website and check the notifications section for the latest updates and official announcements.";
        }

        if (contains(input, "departments", "branches", "courses offered", "btech branches", "available branches")) {
            return "Vasavi College of Engineering offers the following major undergraduate engineering branches:\n\n• Computer Science and Engineering (CSE)\n• Information Technology (IT)\n• Electronics and Communication Engineering (ECE)\n• Electrical and Electronics Engineering (EEE)\n• Civil Engineering\n• Mechanical Engineering\n\nEach department has dedicated faculty, laboratories, departmental activities, and academic events which ensure both theoretical and practical exposure for the students.";
        }

        if (contains(input, "cse department", "about cse", "cse branch")) {
            return "The Computer Science and Engineering (CSE) department at Vasavi College of Engineering focuses on strong computer science fundamentals along with modern technologies. The syllabus usually covers programming, data structures, algorithms, operating systems, database management systems, computer networks, software engineering, machine learning, artificial intelligence, cloud computing, big data, and various emerging technological domains. Students engage in mini-projects, major projects, internships, and industry interaction activities. The department is supported by well-equipped computer laboratories, experienced faculty, and strong placement opportunities in both service-based and product-based companies.";
        }

        if (contains(input, "it department", "about it", "information technology branch", "it branch")) {
            return "The Information Technology (IT) department emphasizes software development, information systems, web technologies, and data-centric applications. Students learn core programming, object-oriented concepts, database systems, computer networks, web development, mobile application development, and cloud and analytics related subjects. The department encourages students to participate in hackathons, coding contests, internships, and industry projects, which help them develop real-world problem-solving and software engineering skills.";
        }

        if (contains(input, "ece department", "about ece", "electronics and communication")) {
            return "The Electronics and Communication Engineering (ECE) department offers a strong foundation in electronic devices and circuits, analog and digital communication, digital signal processing, microprocessors and microcontrollers, VLSI design, embedded systems, and wireless communication. Students gain hands-on exposure to simulation tools, hardware development kits, and lab experiments. Graduates from ECE can work in telecom, semiconductor, embedded systems, signal processing, and can also explore software careers due to their strong analytical and technical foundation.";
        }

        if (contains(input, "eee department", "about eee", "electrical and electronics")) {
            return "The Electrical and Electronics Engineering (EEE) department focuses on electrical machines, power systems, power electronics, control systems, renewable energy, and related technologies. Students learn about generation, transmission, and distribution of electrical energy, as well as industrial drives and automation. With this background, graduates can work in power utilities, manufacturing industries, renewable energy sectors, and also transition into software and interdisciplinary roles if they wish.";
        }

        if (contains(input, "civil department", "about civil", "civil engineering branch")) {
            return "The Civil Engineering department deals with structural engineering, construction technology, transportation engineering, environmental engineering, geotechnical engineering, and infrastructure development. Students learn to plan, design, and analyze buildings, bridges, roads, water supply systems, and other structures. They gain field exposure through site visits and practical assignments. Civil engineering graduates can work in government departments, private construction firms, consulting companies, and infrastructure development organizations.";
        }

        if (contains(input, "mechanical department", "about mechanical", "mech branch")) {
            return "The Mechanical Engineering department covers engineering mechanics, thermodynamics, manufacturing technology, machine design, heat transfer, fluid mechanics, and related areas. The department supports practical learning through workshops, thermal labs, CAD/CAM labs, and manufacturing labs. Mechanical engineers can find opportunities in automobile industries, manufacturing sectors, design and analysis roles, and can also pivot towards interdisciplinary areas such as robotics, automation, and even software-related roles with additional skills.";
        }

        if (contains(input, "fees", "fee structure", "college fees", "tuition fees", "how much fee")) {
            return "The fee structure at Vasavi College of Engineering generally includes tuition fees along with examination and other applicable charges as per regulations. For many B.Tech programs, the annual tuition fee is in a range around one lakh to one and a half lakh rupees, depending on the category and year of admission, but the exact numbers are defined by the management and state government norms. In addition, there may be fee reimbursement schemes, scholarships, and financial assistance options available for eligible students through government and private agencies. For precise, updated, and category-wise fee details, students and parents should refer to the official website or directly contact the college office.";
        }

        if (contains(input, "admission", "admissions process", "how to join", "rank required", "entry", "get seat")) {
            return "Admissions to B.Tech programs at Vasavi College of Engineering are primarily based on performance in the TS EAMCET entrance examination for Category-A (convener quota) seats, which typically form 70 percent of the intake. Category-B (management quota) seats constitute the remaining 30 percent and follow separate guidelines as per statutory norms. Candidates must qualify in the entrance examination, participate in the counseling process, and select Vasavi College of Engineering and the desired branch based on their rank and seat availability. Branch-wise cutoff ranks can vary every year depending on competition and demand, so aspirants should check previous year cutoffs and keep track of current year notifications on the official website.";
        }

        if (contains(input, "placements", "placement record", "highest package", "average package", "companies visit")) {
            return "Vasavi College of Engineering has a dedicated Training and Placement Cell that works closely with students to enhance their employability skills and place them in reputed organizations. The college regularly sees visits from top IT services companies, product-based software firms, consulting organizations, and core engineering industries. Many students from CSE, IT, and ECE secure high-paying roles in software development, data-related positions, and emerging technology domains. Mechanical, Civil, and EEE students also get opportunities in relevant core sectors and allied industries. The Training and Placement Cell conducts aptitude training, technical sessions, soft skills workshops, resume preparation guidance, and mock interviews. Placement statistics such as highest package, average package, and company-wise offers are usually published on the official website or placement brochure.";
        }

        if (contains(input, "library", "library timings", "books available", "digital library")) {
            return "The central library at Vasavi College of Engineering is an important academic resource with a large collection of textbooks, reference books, journals, magazines, and project reports. It generally operates during college working hours, often from around 9:30 AM to 6:00 PM, although exact timings can vary. Students can access digital resources such as e-journals, online databases, and e-books through subscriptions provided by the institution. The library environment is designed to support focused study, with separate reading areas for students and faculty. Library rules regarding membership, book borrowing limits, and due dates are to be followed carefully by all users.";
        }

        if (contains(input, "hostel", "accommodation", "stay", "rooms to stay")) {
            return "Vasavi College of Engineering operates mainly as a day-scholar institution and does not provide a full-scale on-campus hostel for all students. Most students arrange accommodation in private hostels, paying guest facilities, and rented rooms in nearby localities such as Mehdipatnam, Tolichowki, Langer House, and other areas within commuting distance. When selecting a place to stay, it is important for students and their parents to personally verify aspects like safety, hygiene, food quality, distance from the college, and transport options before making a final decision.";
        }

        if (contains(input, "transport", "bus facility", "college bus", "buses", "bus routes")) {
            return "The college supports transportation needs by operating buses on certain routes within Hyderabad, depending on student demand and feasibility. Many students also use TSRTC buses and other public or shared transport options. Details regarding college bus routes, pickup points, timing schedules, and transport fees are generally provided by the administrative office or transport in-charge and may be revised periodically. Students interested in using the college bus facility should contact the office for up-to-date information and registration procedures.";
        }

        if (contains(input, "canteen", "food", "mess", "refreshments")) {
            return "The college canteen serves as a central place for students to have meals, snacks, and beverages during breaks. It typically offers South Indian dishes, snacks, tea, coffee, and some packed items at reasonable prices. Cleanliness and hygiene are given importance, and students are expected to maintain discipline, use dustbins properly, and avoid wasting food. The canteen also acts as an informal interaction space where students can relax and catch up with friends between classes.";
        }

        if (contains(input, "timings", "college timings", "class timings", "working hours")) {
            return "On regular working days, Vasavi College of Engineering typically functions approximately from 9:40 AM to 4:20 PM. The day usually includes theory sessions, laboratory classes, and a lunch break in the middle of the day. However, exact timings, including the start time of each period, lab slot allocations, and any special sessions, are determined by the academic timetable released by the departments. During examinations, separate schedules are issued. Students should refer to official timetables and notices for accurate and current information.";
        }

        if (contains(input, "exam timetable", "exam dates", "mid exams", "end exams", "when are exams", "internal exam")) {
            return "Examination timetables for internal (mid) examinations, lab exams, and end-semester theory examinations are prepared and published by the Examination Branch of the college. These timetables are usually displayed on department notice boards and uploaded to the official website under the Examinations or Notifications section. Students should regularly check these sources to stay updated about exam dates, timings, hall allocations, and any changes communicated through official circulars.";
        }

        if (contains(input, "attendance", "attendance rules", "minimum attendance", "shortage of attendance")) {
            return "Attendance is a very important part of the academic regulations at Vasavi College of Engineering. Generally, students are required to maintain a minimum attendance percentage, such as 75 percent in each subject, to be eligible to appear for the end-semester examinations. If a student’s attendance falls below the prescribed minimum, they may be detained in that semester and required to repeat the course as per the applicable regulations. Students are therefore encouraged to attend classes regularly, avoid unnecessary absences, and review their attendance status periodically with the help of class in-charges and mentors.";
        }

        if (contains(input, "results", "exam results", "when results", "where can i see results")) {
            return "Examination results are processed and announced by the Examination Branch. Students can usually view their results through the college website or a dedicated result portal, if provided. Links to the result announcements and any instructions related to revaluation, recounting, or applying for photocopies of answer scripts are published along with the results. Students should carefully read the instructions and adhere to the deadlines mentioned in the notifications.";
        }

        if (contains(input, "syllabus", "subject list", "course structure", "curriculum")) {
            return "The detailed syllabus and course structure for each branch and semester at Vasavi College of Engineering is documented in the Academic Regulations and Syllabus booklets. These documents include unit-wise topics, credit distribution, evaluation schemes, and recommended textbooks. Students can usually download these syllabi from the official website under the Academics or Departments sections. Understanding the syllabus helps students to plan their studies effectively, allocate sufficient time to each subject, and revise systematically before examinations.";
        }

        if (contains(input, "clubs", "technical clubs", "cultural clubs", "student clubs", "activities")) {
            return "Vasavi College of Engineering supports several student clubs and associations that help in overall personality development. Technical clubs focus on coding contests, robotics, electronics projects, and domain-specific activities, while cultural clubs encourage music, dance, theater, literary activities, and arts. There are also professional society chapters such as IEEE, CSI, and others that organize guest lectures, workshops, and competitions. Active participation in clubs helps students develop leadership qualities, teamwork, communication skills, and a strong professional network.";
        }

        if (contains(input, "fest", "fests", "technical fest", "cultural fest", "events")) {
            return "The college organizes various technical, cultural, and sports events throughout the academic year. Technical fests often include paper presentations, project expos, coding competitions, circuit design contests, and other innovation challenges. Cultural fests provide a platform for students to showcase talents in music, dance, drama, fashion shows, and other performances. Sports events include tournaments and matches in games like cricket, football, volleyball, badminton, and athletics. Information about upcoming events, registration procedures, and schedules is usually shared through notices, class announcements, and the official website.";
        }

        if (contains(input, "principal", "who is principal")) {
            return "The Principal of Vasavi College of Engineering is S.V Ramana, the chief academic and administrative head who oversees all educational, disciplinary, and developmental activities of the institution. The Principal works with heads of departments, deans, and administrative staff to ensure that academic quality, examination integrity, and student support systems are maintained. For official concerns, students are generally expected to first approach class in-charges, mentors, or heads of departments before escalating issues to the Principal’s office, except in situations specifically outlined by the college policies.";
        }

        if (contains(input, "gpa", "cgpa", "how to calculate gpa", "credit points")) {
            return "Grade Point Average (GPA) and Cumulative Grade Point Average (CGPA) are numerical indicators of a student’s academic performance. For a given semester, GPA is calculated by multiplying the grade points obtained in each subject by the respective credits of that subject, summing all these products, and then dividing by the total number of credits registered in that semester. CGPA is computed similarly across all completed semesters by considering total earned credits and the corresponding grade points. The exact grade point mapping (for example, which marks correspond to which letter grade and grade point) and formulas are defined in the Academic Regulations of Vasavi College of Engineering.";
        }

        if (contains(input, "ragging", "anti ragging", "complaint", "grievance", "harassment")) {
            return "Vasavi College of Engineering enforces a strict zero-tolerance policy towards ragging, harassment, and any form of misconduct. An Anti-Ragging Committee and a Grievance Redressal Cell function to address student concerns. Any student facing ragging, bullying, or harassment, whether physical, verbal, or online, is strongly encouraged to immediately report the issue to faculty mentors, the Head of the Department, the discipline committee, or directly to the Anti-Ragging Cell. Contact information and procedures for lodging complaints are usually provided in the student handbook and displayed on notice boards or the official website. Confidentiality and appropriate action are assured as per regulatory guidelines.";
        }

        if (contains(input, "lab", "laboratories", "labs available")) {
            return "All departments at Vasavi College of Engineering maintain specialized laboratories that support the practical components of the curriculum. Examples include programming and database labs for CSE and IT, electronics and communication labs for ECE, electrical machines and power systems labs for EEE, material testing and surveying labs for Civil, and workshops, thermal labs, and fluid mechanics labs for Mechanical. Lab sessions are scheduled as part of the timetable and play a vital role in helping students connect theoretical learning with hands-on experimentation and real-world problem solving.";
        }

        if (contains(input, "rules", "discipline", "dress code", "regulations", "code of conduct")) {
            return "The college expects students to maintain high standards of discipline, punctuality, and professional behavior at all times. This includes regular attendance, timely submission of assignments, respectful interaction with faculty and staff, and adherence to examination rules. Depending on the department and course, there may also be guidelines regarding dress code, lab safety, and use of identity cards. Use of mobile phones inside classrooms and labs may be restricted as per college policy. Violations of the code of conduct can result in warnings, disciplinary actions, or other penalties as per the institutional regulations.";
        }

        // ===== Faculty & Department Handling =====
        String dept = extractDepartment(input);
        if (contains(input, "faculty", "hod", "professor", "sir", "madam", "staff", "teachers", "department")) {
            // 1) If department is clearly mentioned: "cse faculty", "it faculty list"
            if (dept != null) {
                List<Faculty> list = FacultyLoader.findByDepartment(dept);
                if (!list.isEmpty()) {
                    return formatFacultyList(list, dept);
                } else {
                    return "I could not find faculty details for the " + dept + " department in the stored records. Please make sure the department data has been updated correctly in the system or contact the respective department office for the latest faculty list.";
                }
            }

            // 2) Otherwise, try to interpret it as a specific faculty name: "faculty aruna"
            String name = extractFacultyName(input);
            if (name != null && name.length() > 1) {
                Faculty f = FacultyLoader.findByName(name);
                if (f != null) {
                    return formatFaculty(f);
                }
            }

            return "If you want to know about a specific faculty member, please type your query in the format \"faculty name\", for example \"faculty ramesh\" or \"faculty sravani\". You can also ask for the faculty of a particular department using queries like \"CSE faculty list\" or \"ECE faculty details\".";
        }

        return "I could not clearly understand your question. Please try asking in a more specific way. You can also type \"help\" to see a list of example questions. Common topics you can ask me about include admissions, fee structure, departments, faculty details, placements, syllabus, examination schedules, college facilities, student clubs, anti-ragging support, and general information about Vasavi College of Engineering.";
    }

    private static boolean contains(String input, String... keys) {
        for (String k : keys) {
            if (input.contains(k)) {
                return true;
            }
        }
        return false;
    }

    private static String extractLastWord(String text) {
        String[] parts = text.trim().split("\\s+");
        if (parts.length > 1) {
            return parts[parts.length - 1];
        }
        return null;
    }

    // NEW: extract everything after the word "faculty"
    private static String extractFacultyName(String text) {
        text = text.trim();
        if (text.startsWith("faculty")) {
            String[] parts = text.split("\\s+", 2);
            if (parts.length == 2) {
                return parts[1].trim(); // e.g., "aruna", "aruna reddy"
            }
        }
        return extractLastWord(text); // fallback
    }

    // FIXED: don't treat "it" inside "faculty" as IT department
    private static String extractDepartment(String text) {
        text = text.toLowerCase().trim();
        String[] words = text.split("\\s+");

        for (String w : words) {
            if (w.equals("cse")) return "CSE";
            if (w.equals("it")) return "IT";
            if (w.equals("ece")) return "ECE";
            if (w.equals("eee")) return "EEE";
            if (w.equals("civil")) return "CIVIL";
            if (w.equals("mech") || w.equals("mechanical")) return "MECH";
        }

        return null;
    }

    private static String formatFaculty(Faculty f) {
        return "Faculty Details:\nName: " + f.getName()
                + "\nDepartment: " + f.getDepartment()
                + "\nDesignation: " + f.getDesignation()
                + "\nEmail: " + f.getEmail()
                + "\nPhone: " + f.getPhone();
    }

    private static String formatFacultyList(List<Faculty> list, String dept) {
        StringBuilder sb = new StringBuilder("Faculty List - " + dept + " Department:\n\n");
        for (Faculty f : list) {
            sb.append("Name: ").append(f.getName()).append("\n")
              .append("Designation: ").append(f.getDesignation()).append("\n")
              .append("Department: ").append(f.getDepartment()).append("\n")
              .append("Email: ").append(f.getEmail()).append("\n")
              .append("Phone: ").append(f.getPhone()).append("\n\n");
        }
        return sb.toString();
    }
}
