--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-08-07 19:20:10 FET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "ProjectDataBase";
--
-- TOC entry 2154 (class 1262 OID 38997)
-- Name: ProjectDataBase; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "ProjectDataBase" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF8' LC_CTYPE = 'en_US.UTF8';


ALTER DATABASE "ProjectDataBase" OWNER TO postgres;

\connect "ProjectDataBase"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 196 (class 3079 OID 11769)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 196
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 209 (class 1255 OID 38998)
-- Name: logstudentstate(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION logstudentstate() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	if OLD.state <> NEW.state then
		insert into student_log (student_id,new_state,time) values (NEW.id,NEW.state,NOW());
	end if;
	return NEW;
end;
$$;


ALTER FUNCTION public.logstudentstate() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 38999)
-- Name: curator; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE curator (
    id bigint NOT NULL
);


ALTER TABLE public.curator OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 39245)
-- Name: exadel_practice; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exadel_practice (
    id bigint NOT NULL,
    curator character varying(255),
    interview character varying(255),
    on_probation boolean,
    practicestart timestamp without time zone,
    practicestop timestamp without time zone,
    workinvitation boolean,
    directcurator_id bigint
);


ALTER TABLE public.exadel_practice OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 39318)
-- Name: exadel_work; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exadel_work (
    id bigint NOT NULL,
    billable boolean,
    billablestartdate timestamp without time zone,
    certificates character varying(255),
    curator character varying(255),
    currentprojectrole integer,
    exadeltrainingnextfrom timestamp without time zone,
    exadeltrainingnextto timestamp without time zone,
    exadeltrainingtype character varying(255),
    hoursdesiredtransferdate timestamp without time zone,
    hours_current integer,
    hours_desired integer,
    teamleadoncurrent character varying(255),
    vacationnextdateend timestamp without time zone,
    vacationnextdatestart timestamp without time zone,
    wannachangeproj boolean,
    workstartdate timestamp without time zone,
    isbillable boolean
);


ALTER TABLE public.exadel_work OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 39017)
-- Name: exam; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exam (
    id bigint NOT NULL,
    course integer,
    grade double precision NOT NULL,
    summer boolean,
    student_fk bigint
);


ALTER TABLE public.exam OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 39020)
-- Name: feedback; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedback (
    id bigint NOT NULL,
    billablenow boolean,
    collectiverelations character varying(255),
    feedback character varying(255),
    feedbackdate timestamp without time zone,
    needmorehours boolean,
    onrealproject boolean,
    profcompetence boolean,
    profmattersprogress character varying(255),
    projectprospect boolean,
    workattitude character varying(255),
    author bigint,
    student_id bigint
);


ALTER TABLE public.feedback OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 39026)
-- Name: feedbackable; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedbackable (
    id bigint NOT NULL
);


ALTER TABLE public.feedbackable OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 39029)
-- Name: feedbacker; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedbacker (
    id bigint NOT NULL
);


ALTER TABLE public.feedbacker OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 39032)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 39034)
-- Name: joanna; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE joanna (
    id bigint NOT NULL
);


ALTER TABLE public.joanna OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 39580)
-- Name: personneldepartment; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personneldepartment (
    id bigint NOT NULL
);


ALTER TABLE public.personneldepartment OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 39671)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE project (
    id bigint NOT NULL,
    title character varying(255)
);


ALTER TABLE public.project OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 39692)
-- Name: project_exadel_work; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE project_exadel_work (
    currentprojects_id bigint NOT NULL,
    students_id bigint NOT NULL
);


ALTER TABLE public.project_exadel_work OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 39669)
-- Name: project_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.project_id_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 192
-- Name: project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE project_id_seq OWNED BY project.id;


--
-- TOC entry 194 (class 1259 OID 39687)
-- Name: project_technology; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE project_technology (
    project_id bigint NOT NULL,
    usedtechnologies_id bigint NOT NULL
);


ALTER TABLE public.project_technology OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 39037)
-- Name: skill; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE skill (
    id bigint NOT NULL,
    level character varying(255),
    type_id bigint
);


ALTER TABLE public.skill OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 39040)
-- Name: skill_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE skill_type (
    id bigint NOT NULL,
    type character varying(255)
);


ALTER TABLE public.skill_type OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 39043)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student (
    email character varying(255),
    english character varying(255),
    phone character varying(255),
    skype character varying(255),
    state character varying(255),
    course_group character varying(255),
    faculty character varying(255),
    graduate_year integer,
    specialty character varying(255),
    university character varying(255),
    id bigint NOT NULL,
    curator bigint,
    curator_id bigint
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 39565)
-- Name: student_curator; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_curator (
    students_id bigint NOT NULL,
    curator_id bigint NOT NULL
);


ALTER TABLE public.student_curator OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 39492)
-- Name: student_current_used_technologies; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_current_used_technologies (
    stud_id bigint NOT NULL,
    currentusedtech_id bigint NOT NULL
);


ALTER TABLE public.student_current_used_technologies OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 39497)
-- Name: student_desired_used_technologies; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_desired_used_technologies (
    stud_id bigint NOT NULL,
    desiredusedtech_id bigint NOT NULL
);


ALTER TABLE public.student_desired_used_technologies OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 39049)
-- Name: student_log; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_log (
    new_state integer,
    "time" timestamp without time zone,
    student_id bigint,
    id integer NOT NULL
);


ALTER TABLE public.student_log OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 39052)
-- Name: student_log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE student_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_log_id_seq OWNER TO postgres;

--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 181
-- Name: student_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE student_log_id_seq OWNED BY student_log.id;


--
-- TOC entry 182 (class 1259 OID 39054)
-- Name: student_skill; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_skill (
    student_id bigint NOT NULL,
    skillset_id bigint NOT NULL
);


ALTER TABLE public.student_skill OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 39057)
-- Name: technology; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE technology (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.technology OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 39060)
-- Name: user_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_ (
    id bigint NOT NULL,
    first_name character varying(255),
    login character varying(255),
    pass character varying(255),
    second_name character varying(255),
    surname character varying(255)
);


ALTER TABLE public.user_ OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 39066)
-- Name: user__id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user__id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user__id_seq OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 185
-- Name: user__id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user__id_seq OWNED BY user_.id;


--
-- TOC entry 1939 (class 2604 OID 39674)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project ALTER COLUMN id SET DEFAULT nextval('project_id_seq'::regclass);


--
-- TOC entry 1937 (class 2604 OID 39068)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_log ALTER COLUMN id SET DEFAULT nextval('student_log_id_seq'::regclass);


--
-- TOC entry 1938 (class 2604 OID 39069)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_ ALTER COLUMN id SET DEFAULT nextval('user__id_seq'::regclass);


--
-- TOC entry 2124 (class 0 OID 38999)
-- Dependencies: 170
-- Data for Name: curator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY curator (id) FROM stdin;
2
6
\.


--
-- TOC entry 2140 (class 0 OID 39245)
-- Dependencies: 186
-- Data for Name: exadel_practice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exadel_practice (id, curator, interview, on_probation, practicestart, practicestop, workinvitation, directcurator_id) FROM stdin;
\.


--
-- TOC entry 2141 (class 0 OID 39318)
-- Dependencies: 187
-- Data for Name: exadel_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exadel_work (id, billable, billablestartdate, certificates, curator, currentprojectrole, exadeltrainingnextfrom, exadeltrainingnextto, exadeltrainingtype, hoursdesiredtransferdate, hours_current, hours_desired, teamleadoncurrent, vacationnextdateend, vacationnextdatestart, wannachangeproj, workstartdate, isbillable) FROM stdin;
1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N
\.


--
-- TOC entry 2125 (class 0 OID 39017)
-- Dependencies: 171
-- Data for Name: exam; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exam (id, course, grade, summer, student_fk) FROM stdin;
27	1	1	t	1
31	2	1	f	1
\.


--
-- TOC entry 2126 (class 0 OID 39020)
-- Dependencies: 172
-- Data for Name: feedback; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedback (id, billablenow, collectiverelations, feedback, feedbackdate, needmorehours, onrealproject, profcompetence, profmattersprogress, projectprospect, workattitude, author, student_id) FROM stdin;
32	f	1	\N	2014-08-04 14:09:17.59	t	t	t	1	\N	1	3	1
\.


--
-- TOC entry 2127 (class 0 OID 39026)
-- Dependencies: 173
-- Data for Name: feedbackable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedbackable (id) FROM stdin;
3
2
4
5
6
7
\.


--
-- TOC entry 2128 (class 0 OID 39029)
-- Dependencies: 174
-- Data for Name: feedbacker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedbacker (id) FROM stdin;
7
\.


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 175
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 32, true);


--
-- TOC entry 2130 (class 0 OID 39034)
-- Dependencies: 176
-- Data for Name: joanna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY joanna (id) FROM stdin;
3
4
5
\.


--
-- TOC entry 2145 (class 0 OID 39580)
-- Dependencies: 191
-- Data for Name: personneldepartment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY personneldepartment (id) FROM stdin;
\.


--
-- TOC entry 2147 (class 0 OID 39671)
-- Dependencies: 193
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY project (id, title) FROM stdin;
1	fapproject
\.


--
-- TOC entry 2149 (class 0 OID 39692)
-- Dependencies: 195
-- Data for Name: project_exadel_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY project_exadel_work (currentprojects_id, students_id) FROM stdin;
\.


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 192
-- Name: project_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('project_id_seq', 1, true);


--
-- TOC entry 2148 (class 0 OID 39687)
-- Dependencies: 194
-- Data for Name: project_technology; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY project_technology (project_id, usedtechnologies_id) FROM stdin;
\.


--
-- TOC entry 2131 (class 0 OID 39037)
-- Dependencies: 177
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skill (id, level, type_id) FROM stdin;
30	12	1
\.


--
-- TOC entry 2132 (class 0 OID 39040)
-- Dependencies: 178
-- Data for Name: skill_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skill_type (id, type) FROM stdin;
1	fapskill
\.


--
-- TOC entry 2133 (class 0 OID 39043)
-- Dependencies: 179
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student (email, english, phone, skype, state, course_group, faculty, graduate_year, specialty, university, id, curator, curator_id) FROM stdin;
a@a.aa	beginner	1	a	\N	1/1	a	1990	a	a	1	2	\N
\.


--
-- TOC entry 2144 (class 0 OID 39565)
-- Dependencies: 190
-- Data for Name: student_curator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_curator (students_id, curator_id) FROM stdin;
\.


--
-- TOC entry 2142 (class 0 OID 39492)
-- Dependencies: 188
-- Data for Name: student_current_used_technologies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_current_used_technologies (stud_id, currentusedtech_id) FROM stdin;
\.


--
-- TOC entry 2143 (class 0 OID 39497)
-- Dependencies: 189
-- Data for Name: student_desired_used_technologies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_desired_used_technologies (stud_id, desiredusedtech_id) FROM stdin;
\.


--
-- TOC entry 2134 (class 0 OID 39049)
-- Dependencies: 180
-- Data for Name: student_log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_log (new_state, "time", student_id, id) FROM stdin;
\.


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 181
-- Name: student_log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('student_log_id_seq', 1, false);


--
-- TOC entry 2136 (class 0 OID 39054)
-- Dependencies: 182
-- Data for Name: student_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_skill (student_id, skillset_id) FROM stdin;
1	30
\.


--
-- TOC entry 2137 (class 0 OID 39057)
-- Dependencies: 183
-- Data for Name: technology; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY technology (id, name) FROM stdin;
1	faptechnology
\.


--
-- TOC entry 2138 (class 0 OID 39060)
-- Dependencies: 184
-- Data for Name: user_; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_ (id, first_name, login, pass, second_name, surname) FROM stdin;
1	a	vitya	1	a	a
3	\N	joanna	1	\N	\N
2	curator	dfg	1	\N	surcurator
4	\N	admin	admin	\N	\N
5	\N	j	j	\N	\N
6	\N	curator	1	\N	\N
7	\N	feedbacker	1	\N	\N
\.


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 185
-- Name: user__id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user__id_seq', 7, true);


--
-- TOC entry 1941 (class 2606 OID 39071)
-- Name: curator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY curator
    ADD CONSTRAINT curator_pkey PRIMARY KEY (id);


--
-- TOC entry 1971 (class 2606 OID 39252)
-- Name: exadel_practice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT exadel_practice_pkey PRIMARY KEY (id);


--
-- TOC entry 1973 (class 2606 OID 39325)
-- Name: exadel_work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_work
    ADD CONSTRAINT exadel_work_pkey PRIMARY KEY (id);


--
-- TOC entry 1943 (class 2606 OID 39081)
-- Name: exam_course_student_fk_summer_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT exam_course_student_fk_summer_key UNIQUE (course, student_fk, summer);


--
-- TOC entry 1945 (class 2606 OID 39083)
-- Name: exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


--
-- TOC entry 1947 (class 2606 OID 39085)
-- Name: feedback_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);


--
-- TOC entry 1949 (class 2606 OID 39087)
-- Name: feedbackable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedbackable
    ADD CONSTRAINT feedbackable_pkey PRIMARY KEY (id);


--
-- TOC entry 1951 (class 2606 OID 39089)
-- Name: feedbacker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedbacker
    ADD CONSTRAINT feedbacker_pkey PRIMARY KEY (id);


--
-- TOC entry 1953 (class 2606 OID 39091)
-- Name: joanna_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY joanna
    ADD CONSTRAINT joanna_pkey PRIMARY KEY (id);


--
-- TOC entry 1981 (class 2606 OID 39584)
-- Name: personneldepartment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personneldepartment
    ADD CONSTRAINT personneldepartment_pkey PRIMARY KEY (id);


--
-- TOC entry 1987 (class 2606 OID 39696)
-- Name: project_exadel_work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project_exadel_work
    ADD CONSTRAINT project_exadel_work_pkey PRIMARY KEY (currentprojects_id, students_id);


--
-- TOC entry 1983 (class 2606 OID 39676)
-- Name: project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- TOC entry 1985 (class 2606 OID 39691)
-- Name: project_technology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project_technology
    ADD CONSTRAINT project_technology_pkey PRIMARY KEY (project_id, usedtechnologies_id);


--
-- TOC entry 1955 (class 2606 OID 39093)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 1957 (class 2606 OID 39095)
-- Name: skill_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill_type
    ADD CONSTRAINT skill_type_pkey PRIMARY KEY (id);


--
-- TOC entry 1979 (class 2606 OID 39569)
-- Name: student_curator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_curator
    ADD CONSTRAINT student_curator_pkey PRIMARY KEY (students_id, curator_id);


--
-- TOC entry 1975 (class 2606 OID 39496)
-- Name: student_current_used_technologies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_current_used_technologies
    ADD CONSTRAINT student_current_used_technologies_pkey PRIMARY KEY (stud_id, currentusedtech_id);


--
-- TOC entry 1977 (class 2606 OID 39501)
-- Name: student_desired_used_technologies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_desired_used_technologies
    ADD CONSTRAINT student_desired_used_technologies_pkey PRIMARY KEY (stud_id, desiredusedtech_id);


--
-- TOC entry 1959 (class 2606 OID 39097)
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 1961 (class 2606 OID 39099)
-- Name: student_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT student_skill_pkey PRIMARY KEY (student_id, skillset_id);


--
-- TOC entry 1963 (class 2606 OID 39101)
-- Name: student_skill_skillset_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT student_skill_skillset_id_key UNIQUE (skillset_id);


--
-- TOC entry 1965 (class 2606 OID 39103)
-- Name: technology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY technology
    ADD CONSTRAINT technology_pkey PRIMARY KEY (id);


--
-- TOC entry 1967 (class 2606 OID 39105)
-- Name: user__login_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__login_key UNIQUE (login);


--
-- TOC entry 1969 (class 2606 OID 39107)
-- Name: user__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__pkey PRIMARY KEY (id);


--
-- TOC entry 2016 (class 2620 OID 39108)
-- Name: onchangestate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER onchangestate AFTER UPDATE OF state ON student FOR EACH ROW EXECUTE PROCEDURE logstudentstate();


--
-- TOC entry 2011 (class 2606 OID 39585)
-- Name: fk15a69172be0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personneldepartment
    ADD CONSTRAINT fk15a69172be0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 2012 (class 2606 OID 39697)
-- Name: fk17d3b212aa56dbf4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_technology
    ADD CONSTRAINT fk17d3b212aa56dbf4 FOREIGN KEY (usedtechnologies_id) REFERENCES technology(id);


--
-- TOC entry 2013 (class 2606 OID 39702)
-- Name: fk17d3b212b3008478; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_technology
    ADD CONSTRAINT fk17d3b212b3008478 FOREIGN KEY (project_id) REFERENCES project(id);


--
-- TOC entry 2006 (class 2606 OID 39517)
-- Name: fk1accda24bd5746d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_current_used_technologies
    ADD CONSTRAINT fk1accda24bd5746d FOREIGN KEY (stud_id) REFERENCES exadel_work(id);


--
-- TOC entry 2005 (class 2606 OID 39512)
-- Name: fk1accda2b2c7646f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_current_used_technologies
    ADD CONSTRAINT fk1accda2b2c7646f FOREIGN KEY (currentusedtech_id) REFERENCES technology(id);


--
-- TOC entry 1989 (class 2606 OID 39109)
-- Name: fk2fb81faf4a622f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT fk2fb81faf4a622f FOREIGN KEY (student_fk) REFERENCES student(id);


--
-- TOC entry 2002 (class 2606 OID 39590)
-- Name: fk33666ffd2b42963a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT fk33666ffd2b42963a FOREIGN KEY (directcurator_id) REFERENCES user_(id);


--
-- TOC entry 2003 (class 2606 OID 39278)
-- Name: fk33666ffdecd3ee01; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT fk33666ffdecd3ee01 FOREIGN KEY (id) REFERENCES student(id);


--
-- TOC entry 2014 (class 2606 OID 39707)
-- Name: fk3d4e32ad4839ae85; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_exadel_work
    ADD CONSTRAINT fk3d4e32ad4839ae85 FOREIGN KEY (students_id) REFERENCES exadel_work(id);


--
-- TOC entry 2015 (class 2606 OID 39712)
-- Name: fk3d4e32ad5e77fc5e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_exadel_work
    ADD CONSTRAINT fk3d4e32ad5e77fc5e FOREIGN KEY (currentprojects_id) REFERENCES project(id);


--
-- TOC entry 1995 (class 2606 OID 39119)
-- Name: fk686ca51c0ce7d56; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT fk686ca51c0ce7d56 FOREIGN KEY (type_id) REFERENCES skill_type(id);


--
-- TOC entry 1994 (class 2606 OID 39124)
-- Name: fk849091851d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY joanna
    ADD CONSTRAINT fk849091851d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1999 (class 2606 OID 39129)
-- Name: fk8c59bf40af4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_log
    ADD CONSTRAINT fk8c59bf40af4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1996 (class 2606 OID 39134)
-- Name: fk8ffe823b16993fd1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823b16993fd1 FOREIGN KEY (curator) REFERENCES curator(id);


--
-- TOC entry 1998 (class 2606 OID 39537)
-- Name: fk8ffe823b28e88a9f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823b28e88a9f FOREIGN KEY (curator_id) REFERENCES curator(id);


--
-- TOC entry 1997 (class 2606 OID 39139)
-- Name: fk8ffe823bbe0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823bbe0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 1993 (class 2606 OID 39144)
-- Name: fk9d9b07121d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedbacker
    ADD CONSTRAINT fk9d9b07121d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 2004 (class 2606 OID 39341)
-- Name: fk9f1e66d3ecd3ee01; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_work
    ADD CONSTRAINT fk9f1e66d3ecd3ee01 FOREIGN KEY (id) REFERENCES student(id);


--
-- TOC entry 1992 (class 2606 OID 39154)
-- Name: fka2e4fe9fbe0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedbackable
    ADD CONSTRAINT fka2e4fe9fbe0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 1988 (class 2606 OID 39159)
-- Name: fka65cd3761d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY curator
    ADD CONSTRAINT fka65cd3761d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 2009 (class 2606 OID 39570)
-- Name: fkd10e917228e88a9f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_curator
    ADD CONSTRAINT fkd10e917228e88a9f FOREIGN KEY (curator_id) REFERENCES curator(id);


--
-- TOC entry 2010 (class 2606 OID 39575)
-- Name: fkd10e917279368608; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_curator
    ADD CONSTRAINT fkd10e917279368608 FOREIGN KEY (students_id) REFERENCES student(id);


--
-- TOC entry 2000 (class 2606 OID 39174)
-- Name: fkdd47d74daf4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT fkdd47d74daf4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 2001 (class 2606 OID 39179)
-- Name: fkdd47d74deb8ca365; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT fkdd47d74deb8ca365 FOREIGN KEY (skillset_id) REFERENCES skill(id);


--
-- TOC entry 1990 (class 2606 OID 39184)
-- Name: fkf495eb85af4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fkf495eb85af4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1991 (class 2606 OID 39189)
-- Name: fkf495eb85c9c2a285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fkf495eb85c9c2a285 FOREIGN KEY (author) REFERENCES feedbackable(id);


--
-- TOC entry 2008 (class 2606 OID 39527)
-- Name: fkf9b008834bd5746d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_desired_used_technologies
    ADD CONSTRAINT fkf9b008834bd5746d FOREIGN KEY (stud_id) REFERENCES exadel_work(id);


--
-- TOC entry 2007 (class 2606 OID 39522)
-- Name: fkf9b00883c02434ae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_desired_used_technologies
    ADD CONSTRAINT fkf9b00883c02434ae FOREIGN KEY (desiredusedtech_id) REFERENCES technology(id);


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-08-07 19:20:11 FET

--
-- PostgreSQL database dump complete
--

