package com.example.resumemaker

import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.educations.Education
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.languages.Language
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.projects.Project
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.skills.Skill

class GenerateResume(
    val basicInfo: BasicInfo,
    val objective: ArrayList<Objective>,
    val experiences: ArrayList<Experience>,
    val skills: ArrayList<Skill>,
    val educations: ArrayList<Education>,
    val projects: ArrayList<Project>,
    val achivements: ArrayList<Achivement>,
    val languages: ArrayList<Language>,
    val references: ArrayList<Referance>,
    val hobbies:ArrayList<Hobby>
) {
    var className:String=""
    fun template1():String{
        var htmlCode:String="<!DOCTYPE html >\n" +
                "<html>\n" +
                "<head>\n" +
                "\n" +
                "\t<title>Jonathan Doe | Web Designer, Director | name@yourdomain.com</title>\n" +
                "\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
                "\n" +
                "\t<meta name=\"keywords\" content=\"\" />\n" +
                "\t<meta name=\"description\" content=\"\" />\n" +
                "\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/font.css\" media=\"all\" /> \n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/resume.css\" media=\"all\" />\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div id=\"doc2\" class=\"yui-t7\">\n" +
                "\t<div id=\"inner\">\n" +
                "\t\n" +
                "\t\t<div id=\"hd\">\n" +
                "\t\t\t<div class=\"yui-gc\">\n" +
                "\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t<h1>${basicInfo.name}</h1>\n" +
                "\t\t\t\t\t<h2>${basicInfo.designation}</h2>\n" +
                "                    <h3>${basicInfo.address}</h3>\n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div class=\"yui-u\">\n" +
                "\t\t\t\t\t<div class=\"contact-info\">\n" +
                "\t\t\t\t\t\t<h3>${basicInfo.gmail}</h3>\n" +
                "\t\t\t\t\t\t<h3>${basicInfo.phone}</h3>\n" +
                "                        <h3>${basicInfo.github}</h3>\n" +
                "                        <h3>${basicInfo.linkedin}</h3>\n" +
                "                        <h3>${basicInfo.dob}</h3>\n" +
                "\t\t\t\t\t</div><!--// .contact-info -->\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div><!--// .yui-gc -->\n" +
                "\t\t</div><!--// hd -->\n" +
                "\n" +
                "\t\t<div id=\"bd\">\n" +
                "\t\t\t<div id=\"yui-main\">\n" +
                "\t\t\t\t<div class=\"yui-b\">\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Profile</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">\n" +
                "\t\t\t\t\t\t\t<p class=\"enlarge\">\n" +
                "\t\t\t\t\t\t\t\t${objective.get(0).data}\n" +
                "\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Skills</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">\n"

        for(i in skills){

            htmlCode=htmlCode+"<div class=\"talent\">\n" +
                    "\t\t\t\t\t\t\t\t\t<h3>${i.title}</h3>\n" +
                    "\t\t\t\t\t\t\t\t\t<p>${i.expLevel}\t</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>"
        }

        htmlCode=htmlCode+"          \n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\t\t\t\t\t\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Experience</h2>\n" +
                "\t\t\t\t\t\t</div><!--// .yui-u -->\n" +
                "\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"
        var num:Int=experiences.size
        var n:Int=0
        for(i in experiences){
            if(++n==num){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "\t\t\t\t\t\t\t\t<h2>${i.company} (${i.city})</h2>\n" +
                    "\t\t\t\t\t\t\t\t<h3>${i.title}</h3>\n" +
                    "\t\t\t\t\t\t\t\t<h4>${i.startDate}-${i.EndDate}</h4>\n" +
                    "\t\t\t\t\t\t\t\t<p>${i.details}</p>\n" +
                    "\t\t\t\t\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t</div><!--// .yui-u -->\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t<div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Education</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num2:Int=educations.size
        var n2:Int=0
        for (i in educations){
            if(++n2==num2){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.school} (${i.city})</h2>\n" +
                    "                                <h4>${i.startDate}-${i.endDate}</h4>\n" +
                    "                                <h3>${i.degree}</h3>\n" +
                    "                                <p>${i.details}</p>\n" +
                    "                            </div>"
        }
        htmlCode=htmlCode+"</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Projects</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num3:Int=projects.size
        var n3:Int=0
        for (i in projects){
            if(++n3==num3){
                className="job last"
            }
            else{
                className="job"
            }

            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.title}</h2>                \n" +
                    "                                <p>${i.details}</p>\n" +
                    "                            </div>"
        }

        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Achievements</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num4:Int=achivements.size
        var n4:Int=0
        for (i in achivements){
            if(++n4==num4){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.title}</h2>                \n" +
                    "                                <p>${i.details} </p>\n" +
                    "                            </div>"
        }

        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Languages</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num5:Int=languages.size
        var n5:Int=0
        for (i in languages){
            if(++n5==num5){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.lang}</h2>                \n" +
                    "                                <p>${i.expLevel}</p>\n" +
                    "                            </div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Hobbies</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"

        var num9:Int=languages.size
        var n9:Int=0
        for (i in hobbies){
            if(++n9==num9){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h2>${i.title}</h2>                \n" +

                    "                            </div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "                    <div class=\"yui-gf last\">\n" +
                "\t\t\t\t\t\t<div class=\"yui-u first\">\n" +
                "\t\t\t\t\t\t\t<h2>Referance</h2>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"yui-u\">"
        var num6:Int=references.size
        var n6:Int=0
        for (i in references){
            if(++n6==num6){
                className="job last"
            }
            else{
                className="job"
            }
            htmlCode=htmlCode+"<div class=\"$className\">\n" +
                    "                                <h3>${i.personName}</h3> \n" +
                    "                                <h2>${i.companyName}</h2>\n" +
                    "                                \n" +
                    "                                <h3>${i.phone}</h3> \n" +
                    "                                <h3>${i.gmail}</h3>                \n" +
                    "                            </div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div><!--// .yui-gf -->\n" +
                "\n" +
                "\n" +
                "\t\t\t\t</div><!--// .yui-b -->\n" +
                "\t\t\t</div><!--// yui-main -->\n" +
                "\t\t</div><!--// bd -->\n" +
                "\n" +
                "\t\t\n" +
                "\t</div><!-- // inner -->\n" +
                "\n" +
                "\n" +
                "</div><!--// doc -->\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n"

        return htmlCode

    }

    fun template2():String{
        var htmlCode:String="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Cv Templet</title>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/styletemp2.css\" media=\"all\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"Cv_Templet\">\n" +
                "\t<div id=\"Group_5\">\n" +
                "\t\t<svg class=\"Path_15\" viewBox=\"0 0 780.276 1103.987\">\n" +
                "\t\t\t<path id=\"Path_15\" d=\"M 0 0 L 772.7133178710938 0 L 780.275634765625 0 L 780.275634765625 1103.986694335938 L 0 1103.986694335938 L 0 0 Z\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t\t<div id=\"Group_3\">\n" +
                "\t\t\t<div id=\"Group_2\">\n" +
                "\t\t\t\t<img id=\"Group_1\" src=\"man.jpg\" srcset=\"man.jpg 1x, man.jpg 2x\">\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<svg class=\"Path_1\" viewBox=\"315.195 -56.484 280.022 282.393\">\n" +
                "\t\t\t\t<path id=\"Path_1\" d=\"M 571.0199584960938 225.9092102050781 L 569.148193359375 224.8579711914062 C 584.797607421875 197.0065002441406 593.0712280273438 165.2934875488281 593.0712280273438 133.1479034423828 C 593.0712280273438 29.76797103881836 508.965087890625 -54.33824920654297 405.5850830078125 -54.33824920654297 C 374.3715209960938 -54.33824920654297 343.4698486328125 -46.51288986206055 316.21875 -31.71024703979492 L 315.1950073242188 -33.59514999389648 C 342.758056640625 -48.56949996948242 374.0149536132812 -56.48400115966797 405.5850830078125 -56.48400115966797 C 510.148681640625 -56.48400115966797 595.2169799804688 28.58433723449707 595.2169799804688 133.1479034423828 C 595.2169799804688 165.6604919433594 586.8489379882812 197.7379302978516 571.0199584960938 225.9092102050781 Z\">\n" +
                "\t\t\t\t</path>\n" +
                "\t\t\t</svg>\n" +
                "\t\t\t<svg class=\"Path_2\" viewBox=\"224.743 27.341 46.354 206.671\">\n" +
                "\t\t\t\t<path id=\"Path_2\" d=\"M 267.6893615722656 234.0117492675781 C 239.5941314697266 197.3177490234375 224.7429962158203 153.4302215576172 224.7429962158203 107.0967330932617 C 224.7429962158203 79.47990417480469 230.0464324951172 52.64691925048828 240.5051422119141 27.34099769592285 L 244.4702301025391 28.98078155517578 C 234.2277984619141 53.76371002197266 229.0344848632812 80.04616546630859 229.0344848632812 107.0967330932617 C 229.0344848632812 152.4798889160156 243.5802154541016 195.4643096923828 271.097412109375 231.4032897949219 L 267.6893615722656 234.0117492675781 Z\">\n" +
                "\t\t\t\t</path>\n" +
                "\t\t\t</svg>\n" +
                "\t\t\t<svg class=\"Path_3\" viewBox=\"384.154 -94.241 186.872 102.422\">\n" +
                "\t\t\t\t<path id=\"Path_3\" d=\"M 555.3839111328125 8.180757522583008 C 513.5215454101562 -44.18229293823242 451.1112365722656 -74.21357727050781 384.1539916992188 -74.21357727050781 L 384.1539916992188 -94.24099731445312 C 457.22998046875 -94.24099731445312 525.3434448242188 -61.46755599975586 571.0254516601562 -4.325394630432129 L 555.3839111328125 8.180757522583008 Z\">\n" +
                "\t\t\t\t</path>\n" +
                "\t\t\t</svg>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Rectangle_3\">\n" +
                "\t\t\t<rect id=\"Rectangle_3\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"780.276\" height=\"20.285\">\n" +
                "\t\t\t</rect>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "\t<div id=\"Marie\">\n" +
                "\t\t<span>${basicInfo.name}</span>\n" +
                "\t</div>\n" +
                "\t<div id=\"Manager_Producer\">\n" +
                "\t\t<span>${basicInfo.designation}</span>\n" +
                "\t</div>\n" +
                "\t<svg class=\"Rectangle_5\">\n" +
                "\t\t<rect id=\"Rectangle_5\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"26.513\" height=\"2.622\">\n" +
                "\t\t</rect>\n" +
                "\t</svg>\n" +
                "\t<div id=\"P_058_302_59_35\">\n" +
                "\t\t<span>P</span><span style=\"font-style:normal;font-weight:bold;color:rgba(10,10,10,1);\"> ${basicInfo.phone}</span>\n" +
                "\t</div>\n" +
                "\t<div id=\"E__julesmailcom\">\n" +
                "\t\t<span>E </span><span style=\"font-style:normal;font-weight:bold;color:rgba(10,10,10,1);\"> ${basicInfo.gmail}</span>\n" +
                "\t</div>\n" +
                "\t<div id=\"Group_7\">\n" +
                "\t\t<svg class=\"Rectangle_12\">\n" +
                "\t\t\t<rect id=\"Rectangle_12\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"1.311\" height=\"650.97\">\n" +
                "\t\t\t</rect>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "\t<div id=\"Profile\">\n" +
                "\t\t<div id=\"Profile_\">\n" +
                "\t\t\t<span>Profile</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"Lorem_ipsum_dolor_sit_amet_con\">\n" +
                "\t\t\t<span>${objective.get(0).data}</span>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Rectangle_23\">\n" +
                "\t\t\t<rect id=\"Rectangle_23\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"397\" height=\"131\">\n" +
                "\t\t\t</rect>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n"
        for (i in experiences){
            htmlCode=htmlCode+"<div id=\"EXPERIENCE\">\n" +
                    "\t\t<svg class=\"Rectangle_29\">\n" +
                    "\t\t\t<rect id=\"Rectangle_29\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"397\" height=\"162\">\n" +
                    "\t\t\t</rect>\n" +
                    "\t\t</svg>\n" +
                    "\t\t<div id=\"Quentum_Comp\">\n" +
                    "\t\t\t<span>${i.company}</span>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div id=\"Supervisor\">\n" +
                    "\t\t\t<span>${i.title}</span>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div id=\"Lorem_ipsum_dolor_sit_amet_con_\">\n" +
                    "\t\t\t<span>${i.details}</span>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div id=\"n_018_-_2020\">\n" +
                    "\t\t\t<span>${i.startDate} - ${i.EndDate}</span>\n" +
                    "\t\t</div>\n" +
                    "\t</div>"
        }
        htmlCode=htmlCode+"<div id=\"EDUCATION\">\n" +
                "\t\t<div id=\"EDUCATION_bg\">\n" +
                "\t\t\t<span>EDUCATION</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"educationset\">"
        for (i in educations){
            htmlCode=htmlCode+"<div id=\"Name_School_BARCHELOR_2002_-_2\">\n" +
                    "\t\t\t\t<span>${i.degree} (${i.school}) ${i.startDate} - ${i.endDate}</span>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"</div>\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "\t<div id=\"Skills\">\n" +
                "\t\t<div id=\"skills\">\n" +
                "\t\t\t<span>skills</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"skillset\">"
        for (i in skills){
            htmlCode=htmlCode+"<div id=\"Skill_1\">\n" +
                    "\t\t\t\t<span>${i.title} (${i.expLevel})</span>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"</div>\n" +
                "\t</div>\n" +
                "\t<div id=\"Group_21\">\n" +
                "\t\t<div id=\"hobies\">\n" +
                "\t\t\t<span>hobies</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"hobbyset\">"
        for (i in projects){
            htmlCode=htmlCode+"<div id=\"Travel\">\n" +
                    "\t\t\t\t<span>${i.title}</span>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"</div>\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "\t<div id=\"Languages\">\n" +
                "\t\t<div id=\"languages\">\n" +
                "\t\t\t<span>languages</span>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"langset\">"
        for (i in languages){
            htmlCode=htmlCode+"<div id=\"English\">\n" +
                    "\t\t\t\t<span>${i.lang} (${i.expLevel})</span>\n" +
                    "\t\t\t</div>"
        }
        htmlCode=htmlCode+"\n" +
                "\t\t</div>\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"EXPERIENCE_b\">\n" +
                "\t\t<div id=\"EXPERIENCE_ca\">\n" +
                "\t\t\t<span>EXPERIENCE</span>\n" +
                "\t\t</div>\n" +
                "\t\t<svg class=\"Rectangle_30\">\n" +
                "\t\t\t<rect id=\"Rectangle_30\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"378\" height=\"29\">\n" +
                "\t\t\t</rect>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "\t<svg class=\"Path_16\" viewBox=\"1410.669 488.638 46.136 99.447\">\n" +
                "\t\t<path id=\"Path_16\" d=\"M 1456.805419921875 488.6380004882812 C 1431.008178710938 490.5535278320312 1410.6689453125 512.0751342773438 1410.6689453125 538.3615112304688 C 1410.6689453125 564.6478881835938 1431.008178710938 586.1694946289062 1456.805419921875 588.0850830078125 L 1456.805419921875 488.6380004882812 Z\">\n" +
                "\t\t</path>\n" +
                "\t</svg>\n" +
                "\t<div id=\"Group_22\">\n" +
                "\t\t<svg class=\"Path_17\" viewBox=\"962 534 130.663 130.423\">\n" +
                "\t\t\t<path id=\"Path_17\" d=\"M 1092.662475585938 538.4828491210938 C 1092.662475585938 536.979736328125 1092.601806640625 535.4913330078125 1092.5498046875 534 L 961.9998779296875 534 L 961.9998779296875 664.3026733398438 C 963.5697021484375 664.3619995117188 965.1395263671875 664.422607421875 966.722900390625 664.422607421875 C 1036.27783203125 664.422607421875 1092.662475585938 608.0377807617188 1092.662475585938 538.4828491210938 Z\">\n" +
                "\t\t\t</path>\n" +
                "\t\t</svg>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>"

        return htmlCode
    }
}