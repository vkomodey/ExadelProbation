--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-08-01 20:01:27 FET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "ProjectDataBase";
--
-- TOC entry 2113 (class 1262 OID 38997)
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
-- TOC entry 2114 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 191 (class 3079 OID 11769)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2116 (class 0 OID 0)
-- Dependencies: 191
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 198 (class 1255 OID 38998)
-- Name: logstudentstate(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION logstudentstate() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	if OLD.state <> NEW.state then
		insert into student_log (student_id,new_state,time) values (NEW.id,NEW.state,TIMESTAMP);
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
-- TOC entry 187 (class 1259 OID 39245)
-- Name: exadel_practice; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exadel_practice (
    id bigint NOT NULL,
    curator character varying(255),
    interview character varying(255),
    on_probation boolean,
    practicestart timestamp without time zone,
    practicestop timestamp without time zone,
    workinvitation boolean
);


ALTER TABLE public.exadel_practice OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 39318)
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
    workstartdate timestamp without time zone
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
-- TOC entry 186 (class 1259 OID 39200)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE project (
    project_id bigint NOT NULL,
    title character varying(255),
    id bigint NOT NULL
);


ALTER TABLE public.project OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 39377)
-- Name: project_exadel_work; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE project_exadel_work (
    currentprojects_id bigint NOT NULL,
    students_id bigint NOT NULL
);


ALTER TABLE public.project_exadel_work OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 39331)
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
    curator bigint
);


ALTER TABLE public.student OWNER TO postgres;

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
-- TOC entry 2117 (class 0 OID 0)
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
-- TOC entry 2118 (class 0 OID 0)
-- Dependencies: 185
-- Name: user__id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user__id_seq OWNED BY user_.id;


--
-- TOC entry 1919 (class 2604 OID 39068)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_log ALTER COLUMN id SET DEFAULT nextval('student_log_id_seq'::regclass);


--
-- TOC entry 1920 (class 2604 OID 39069)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_ ALTER COLUMN id SET DEFAULT nextval('user__id_seq'::regclass);


--
-- TOC entry 2088 (class 0 OID 38999)
-- Dependencies: 170
-- Data for Name: curator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY curator (id) FROM stdin;
\.


--
-- TOC entry 2105 (class 0 OID 39245)
-- Dependencies: 187
-- Data for Name: exadel_practice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exadel_practice (id, curator, interview, on_probation, practicestart, practicestop, workinvitation) FROM stdin;
\.


--
-- TOC entry 2106 (class 0 OID 39318)
-- Dependencies: 188
-- Data for Name: exadel_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exadel_work (id, billable, billablestartdate, certificates, curator, currentprojectrole, exadeltrainingnextfrom, exadeltrainingnextto, exadeltrainingtype, hoursdesiredtransferdate, hours_current, hours_desired, teamleadoncurrent, vacationnextdateend, vacationnextdatestart, wannachangeproj, workstartdate) FROM stdin;
\.


--
-- TOC entry 2089 (class 0 OID 39017)
-- Dependencies: 171
-- Data for Name: exam; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exam (id, course, grade, summer, student_fk) FROM stdin;
3	1	1	t	1
\.


--
-- TOC entry 2090 (class 0 OID 39020)
-- Dependencies: 172
-- Data for Name: feedback; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedback (id, billablenow, collectiverelations, feedback, feedbackdate, needmorehours, onrealproject, profcompetence, profmattersprogress, projectprospect, workattitude, author, student_id) FROM stdin;
\.


--
-- TOC entry 2091 (class 0 OID 39026)
-- Dependencies: 173
-- Data for Name: feedbackable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedbackable (id) FROM stdin;
\.


--
-- TOC entry 2092 (class 0 OID 39029)
-- Dependencies: 174
-- Data for Name: feedbacker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY feedbacker (id) FROM stdin;
\.


--
-- TOC entry 2119 (class 0 OID 0)
-- Dependencies: 175
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 11, true);


--
-- TOC entry 2094 (class 0 OID 39034)
-- Dependencies: 176
-- Data for Name: joanna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY joanna (id) FROM stdin;
\.


--
-- TOC entry 2104 (class 0 OID 39200)
-- Dependencies: 186
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY project (project_id, title, id) FROM stdin;
\.


--
-- TOC entry 2108 (class 0 OID 39377)
-- Dependencies: 190
-- Data for Name: project_exadel_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY project_exadel_work (currentprojects_id, students_id) FROM stdin;
\.


--
-- TOC entry 2107 (class 0 OID 39331)
-- Dependencies: 189
-- Data for Name: project_technology; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY project_technology (project_id, usedtechnologies_id) FROM stdin;
\.


--
-- TOC entry 2095 (class 0 OID 39037)
-- Dependencies: 177
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skill (id, level, type_id) FROM stdin;
\.


--
-- TOC entry 2096 (class 0 OID 39040)
-- Dependencies: 178
-- Data for Name: skill_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skill_type (id, type) FROM stdin;
1	fapskill
\.


--
-- TOC entry 2097 (class 0 OID 39043)
-- Dependencies: 179
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student (email, english, phone, skype, state, course_group, faculty, graduate_year, specialty, university, id, curator) FROM stdin;
a@a.aa	beginner	1	a	\N	1/1	a	1990	a	a	1	\N
\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2	\N
\.


--
-- TOC entry 2098 (class 0 OID 39049)
-- Dependencies: 180
-- Data for Name: student_log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_log (new_state, "time", student_id, id) FROM stdin;
\.


--
-- TOC entry 2120 (class 0 OID 0)
-- Dependencies: 181
-- Name: student_log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('student_log_id_seq', 1, false);


--
-- TOC entry 2100 (class 0 OID 39054)
-- Dependencies: 182
-- Data for Name: student_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student_skill (student_id, skillset_id) FROM stdin;
\.


--
-- TOC entry 2101 (class 0 OID 39057)
-- Dependencies: 183
-- Data for Name: technology; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY technology (id, name) FROM stdin;
\.


--
-- TOC entry 2102 (class 0 OID 39060)
-- Dependencies: 184
-- Data for Name: user_; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_ (id, first_name, login, pass, second_name, surname) FROM stdin;
1	a	vitya	1	a	a
2	\N	dfg	1	\N	\N
\.


--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 185
-- Name: user__id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user__id_seq', 2, true);


--
-- TOC entry 1922 (class 2606 OID 39071)
-- Name: curator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY curator
    ADD CONSTRAINT curator_pkey PRIMARY KEY (id);


--
-- TOC entry 1954 (class 2606 OID 39252)
-- Name: exadel_practice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT exadel_practice_pkey PRIMARY KEY (id);


--
-- TOC entry 1956 (class 2606 OID 39325)
-- Name: exadel_work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_work
    ADD CONSTRAINT exadel_work_pkey PRIMARY KEY (id);


--
-- TOC entry 1924 (class 2606 OID 39081)
-- Name: exam_course_student_fk_summer_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT exam_course_student_fk_summer_key UNIQUE (course, student_fk, summer);


--
-- TOC entry 1926 (class 2606 OID 39083)
-- Name: exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


--
-- TOC entry 1928 (class 2606 OID 39085)
-- Name: feedback_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);


--
-- TOC entry 1930 (class 2606 OID 39087)
-- Name: feedbackable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedbackable
    ADD CONSTRAINT feedbackable_pkey PRIMARY KEY (id);


--
-- TOC entry 1932 (class 2606 OID 39089)
-- Name: feedbacker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedbacker
    ADD CONSTRAINT feedbacker_pkey PRIMARY KEY (id);


--
-- TOC entry 1934 (class 2606 OID 39091)
-- Name: joanna_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY joanna
    ADD CONSTRAINT joanna_pkey PRIMARY KEY (id);


--
-- TOC entry 1960 (class 2606 OID 39381)
-- Name: project_exadel_work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project_exadel_work
    ADD CONSTRAINT project_exadel_work_pkey PRIMARY KEY (currentprojects_id, students_id);


--
-- TOC entry 1952 (class 2606 OID 39204)
-- Name: project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pkey PRIMARY KEY (project_id);


--
-- TOC entry 1958 (class 2606 OID 39335)
-- Name: project_technology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project_technology
    ADD CONSTRAINT project_technology_pkey PRIMARY KEY (project_id, usedtechnologies_id);


--
-- TOC entry 1936 (class 2606 OID 39093)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 1938 (class 2606 OID 39095)
-- Name: skill_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill_type
    ADD CONSTRAINT skill_type_pkey PRIMARY KEY (id);


--
-- TOC entry 1940 (class 2606 OID 39097)
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 1942 (class 2606 OID 39099)
-- Name: student_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT student_skill_pkey PRIMARY KEY (student_id, skillset_id);


--
-- TOC entry 1944 (class 2606 OID 39101)
-- Name: student_skill_skillset_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT student_skill_skillset_id_key UNIQUE (skillset_id);


--
-- TOC entry 1946 (class 2606 OID 39103)
-- Name: technology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY technology
    ADD CONSTRAINT technology_pkey PRIMARY KEY (id);


--
-- TOC entry 1948 (class 2606 OID 39105)
-- Name: user__login_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__login_key UNIQUE (login);


--
-- TOC entry 1950 (class 2606 OID 39107)
-- Name: user__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__pkey PRIMARY KEY (id);


--
-- TOC entry 1980 (class 2620 OID 39108)
-- Name: onchangestate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER onchangestate AFTER UPDATE OF state ON student FOR EACH ROW EXECUTE PROCEDURE logstudentstate();


--
-- TOC entry 1976 (class 2606 OID 39356)
-- Name: fk17d3b212aa56dbf4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_technology
    ADD CONSTRAINT fk17d3b212aa56dbf4 FOREIGN KEY (usedtechnologies_id) REFERENCES technology(id);


--
-- TOC entry 1977 (class 2606 OID 39361)
-- Name: fk17d3b212b3008478; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_technology
    ADD CONSTRAINT fk17d3b212b3008478 FOREIGN KEY (project_id) REFERENCES project(project_id);


--
-- TOC entry 1962 (class 2606 OID 39109)
-- Name: fk2fb81faf4a622f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT fk2fb81faf4a622f FOREIGN KEY (student_fk) REFERENCES student(id);


--
-- TOC entry 1974 (class 2606 OID 39278)
-- Name: fk33666ffdecd3ee01; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT fk33666ffdecd3ee01 FOREIGN KEY (id) REFERENCES student(id);


--
-- TOC entry 1978 (class 2606 OID 39382)
-- Name: fk3d4e32ad4839ae85; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_exadel_work
    ADD CONSTRAINT fk3d4e32ad4839ae85 FOREIGN KEY (students_id) REFERENCES exadel_work(id);


--
-- TOC entry 1979 (class 2606 OID 39387)
-- Name: fk3d4e32ad5e77fc5e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project_exadel_work
    ADD CONSTRAINT fk3d4e32ad5e77fc5e FOREIGN KEY (currentprojects_id) REFERENCES project(project_id);


--
-- TOC entry 1968 (class 2606 OID 39119)
-- Name: fk686ca51c0ce7d56; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT fk686ca51c0ce7d56 FOREIGN KEY (type_id) REFERENCES skill_type(id);


--
-- TOC entry 1967 (class 2606 OID 39124)
-- Name: fk849091851d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY joanna
    ADD CONSTRAINT fk849091851d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1971 (class 2606 OID 39129)
-- Name: fk8c59bf40af4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_log
    ADD CONSTRAINT fk8c59bf40af4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1969 (class 2606 OID 39134)
-- Name: fk8ffe823b16993fd1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823b16993fd1 FOREIGN KEY (curator) REFERENCES curator(id);


--
-- TOC entry 1970 (class 2606 OID 39139)
-- Name: fk8ffe823bbe0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823bbe0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 1966 (class 2606 OID 39144)
-- Name: fk9d9b07121d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedbacker
    ADD CONSTRAINT fk9d9b07121d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1975 (class 2606 OID 39341)
-- Name: fk9f1e66d3ecd3ee01; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_work
    ADD CONSTRAINT fk9f1e66d3ecd3ee01 FOREIGN KEY (id) REFERENCES student(id);


--
-- TOC entry 1965 (class 2606 OID 39154)
-- Name: fka2e4fe9fbe0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedbackable
    ADD CONSTRAINT fka2e4fe9fbe0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 1961 (class 2606 OID 39159)
-- Name: fka65cd3761d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY curator
    ADD CONSTRAINT fka65cd3761d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1972 (class 2606 OID 39174)
-- Name: fkdd47d74daf4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT fkdd47d74daf4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1973 (class 2606 OID 39179)
-- Name: fkdd47d74deb8ca365; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT fkdd47d74deb8ca365 FOREIGN KEY (skillset_id) REFERENCES skill(id);


--
-- TOC entry 1963 (class 2606 OID 39184)
-- Name: fkf495eb85af4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fkf495eb85af4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1964 (class 2606 OID 39189)
-- Name: fkf495eb85c9c2a285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fkf495eb85c9c2a285 FOREIGN KEY (author) REFERENCES feedbackable(id);


--
-- TOC entry 2115 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-08-01 20:01:27 FET

--
-- PostgreSQL database dump complete
--

